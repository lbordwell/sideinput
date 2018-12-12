package com.lbordwell.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.GenerateSequence;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.View;
import org.apache.beam.sdk.transforms.windowing.AfterPane;
import org.apache.beam.sdk.transforms.windowing.GlobalWindows;
import org.apache.beam.sdk.transforms.windowing.Repeatedly;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.PCollectionView;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SideinputPipeline {
   private static final Logger LOGGER = LoggerFactory.getLogger(SideinputPipeline.class);

    public static void main(String[] args) {
        PipelineOptions options =
                PipelineOptionsFactory.fromArgs(args).withValidation().create();

        Pipeline p = Pipeline.create(options);

        final PCollectionView<Long> sideInput = p
                .apply(GenerateSequence.from(0).withRate(1, Duration.standardSeconds(10)))
                .apply(Window.<Long>into(new GlobalWindows())
                        .triggering(Repeatedly.forever(AfterPane.elementCountAtLeast(1)))
                        .discardingFiredPanes())
                .apply(View.<Long>asSingleton());

        p.apply(GenerateSequence.from(0).withRate(1, Duration.standardSeconds(1)))
                .apply(ParDo.of(new DoFn<Long, Long>() {
                    @ProcessElement
                    public void processElement(ProcessContext context) {
                        LOGGER.info("Main pipeline: {}, side input: {}", context.element(), context.sideInput(sideInput));
                    }
                }).withSideInputs(sideInput));

        p.run();
    }
}
