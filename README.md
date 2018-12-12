# DirectRunner vs DataflowRunner sideinput test
Sample implementation based on the *Slowly-changing lookup cache* pattern described here: https://cloud.google.com/blog/products/gcp/guide-to-common-cloud-dataflow-use-case-patterns-part-1

This pipeline currently produces different results when run with the DirectRunner vs the DataflowRunner.

## Run locally with DirectRunner:
`./gradlew runLocal`

## Run on Dataflow
Follow the quickstart guide: https://cloud.google.com/dataflow/docs/quickstarts/quickstart-java-maven
Replace <PROJECT_ID> and <STORAGE_BUCKET> in build.gradle with your GCP values.
`./gradlew runDataflow`

## DirectRunner Output
```
Dec 12, 2018 3:57:55 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 0, side input: 0
Dec 12, 2018 3:57:56 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 1, side input: 0
Dec 12, 2018 3:57:57 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 2, side input: 0
Dec 12, 2018 3:57:58 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 3, side input: 0
Dec 12, 2018 3:57:59 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 4, side input: 0
Dec 12, 2018 3:58:00 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 5, side input: 0
Dec 12, 2018 3:58:01 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 6, side input: 0
Dec 12, 2018 3:58:02 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 7, side input: 0
Dec 12, 2018 3:58:03 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 8, side input: 0
Dec 12, 2018 3:58:04 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 9, side input: 0
Dec 12, 2018 3:58:05 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 10, side input: 0
Dec 12, 2018 3:58:06 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 11, side input: 1
Dec 12, 2018 3:58:07 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 12, side input: 1
Dec 12, 2018 3:58:08 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 13, side input: 1
Dec 12, 2018 3:58:09 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 14, side input: 1
Dec 12, 2018 3:58:10 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 15, side input: 1
Dec 12, 2018 3:58:11 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 16, side input: 1
Dec 12, 2018 3:58:12 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 17, side input: 1
Dec 12, 2018 3:58:13 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 18, side input: 1
Dec 12, 2018 3:58:14 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 19, side input: 1
Dec 12, 2018 3:58:15 PM com.lbordwell.example.SideinputPipeline$1 processElement
INFO: Main pipeline: 20, side input: 1
```

## DataflowRunner Output
```
I  Main pipeline: 2, side input: 0 
I  Main pipeline: 1, side input: 0 
I  Main pipeline: 3, side input: 0 
I  Main pipeline: 0, side input: 0 
I  Main pipeline: 4, side input: 0 
I  Main pipeline: 5, side input: 0 
I  Main pipeline: 6, side input: 0 
I  Main pipeline: 7, side input: 0 
I  Main pipeline: 8, side input: 0 
I  Main pipeline: 9, side input: 0 
I  Main pipeline: 10, side input: 0 
I  Main pipeline: 11, side input: 0 
I  Main pipeline: 12, side input: 0 
I  Main pipeline: 13, side input: 0 
I  Main pipeline: 14, side input: 0 
I  Main pipeline: 15, side input: 0 
I  Main pipeline: 16, side input: 0 
I  Main pipeline: 17, side input: 0 
I  Main pipeline: 18, side input: 0 
I  Main pipeline: 19, side input: 0 
I  Main pipeline: 20, side input: 0 
```