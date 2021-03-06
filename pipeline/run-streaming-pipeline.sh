set -e
set -u

./gradlew run -DmainClass=com.google.solutions.pipeline.EventProcessingPipeline -Pargs="\
 --jobName=event-processing\
 --project=${PROJECT_ID}\
 --region=${GCP_REGION} \
 --maxNumWorkers=10 \
 --runner=DataflowRunner \
 --subscriptionId=${EVENT_SUB} \
 --suspiciousActivityTopic=${SUSPICIOUS_ACTIVITY_TOPIC} \
 --datasetName=${DATASET} \
 --GCSBucketEventExport=gs://${EVENTS_BUCKET} \
 --enableStreamingEngine \
 --diskSizeGb=30"
