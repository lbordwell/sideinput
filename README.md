# DirectRunner vs DataflowRunner sideinput test
Sample implementation based on the *Slowly-changing lookup cache* pattern described here: https://cloud.google.com/blog/products/gcp/guide-to-common-cloud-dataflow-use-case-patterns-part-1

This pipeline currently produces different results when run with the DirectRunner vs the DataflowRunner.

## Run locally with DirectRunner:
`./gradlew runLocal`

## Run on Dataflow
Follow the quickstart guide: https://cloud.google.com/dataflow/docs/quickstarts/quickstart-java-maven
Replace <PROJECT_ID> and <STORAGE_BUCKET> in build.gradle with your GCP values.
`./gradlew runDataflow`
