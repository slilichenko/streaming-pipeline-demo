/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.solutions.pipeline;

import java.util.List;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.Validation;
import org.apache.beam.sdk.options.Validation.Required;

/**
 * Interface to store pipeline options provided by the user
 */
public interface EventProcessingPipelineOptions extends DataflowPipelineOptions {

  @Description("Pub/Sub subscription to receive raw messages from")
  String getSubscriptionId();

  void setSubscriptionId(String value);

  @Description("Another Pub/Sub subscription to receive raw messages from")
  String getAnotherSubscriptionId();
  void setAnotherSubscriptionId(String value);

  @Description("Google Cloud Storage files to process")
  List<String> getFileList();
  void setFileList(List<String> value);

  @Description("BigQuery dataset")
  @Validation.Required
  String getDatasetName();

  void setDatasetName(String value);

  @Description("Table name for main events")
  @Validation.Required
  @Default.String("events")
  String getEventsTable();

  void setEventsTable(String value);

  @Description("Table name for user event findings")
  @Validation.Required
  @Default.String("findings")
  String getUserEventFindingsTable();

  void setUserEventFindingsTable(String value);

  @Description("Optional GCS bucket for exporting events")
  String getGCSBucketEventExport();

  void setGCSBucketEventExport(String value);

  @Description("Table name for threats")
  @Validation.Required
  @Default.String("threats")
  String getThreatsTable();

  void setThreatsTable(String value);

  @Description("Table name for invalid messages")
  @Required
  @Default.String("invalid_messages")
  String getInvalidMessagesTable();
  void setInvalidMessagesTable(String value);

  @Description("Table name for process metadata")
  @Required
  @Default.String("process_info")
  String getProcessInfoTableName();
  void setProcessInfoTableName(String value);

  @Description("Threat detection threshold")
  @Required
  @Default.Integer(2)
  int getThreatThreshold();
  void setThreatThreshold(int value);

  @Description("Table name for process metadata")
  String getSuspiciousActivityTopic();
  void setSuspiciousActivityTopic(String value);

  @Description("Shutdown the pipeline after the number of messages read")
  Long getMaxMessagesToRead();
  void setMaxMessagesToRead(Long value);
}
