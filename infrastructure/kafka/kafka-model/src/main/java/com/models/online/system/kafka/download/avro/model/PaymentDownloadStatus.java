/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.models.online.system.kafka.download.avro.model;
@org.apache.avro.specific.AvroGenerated
public enum PaymentDownloadStatus implements org.apache.avro.generic.GenericEnumSymbol<PaymentDownloadStatus> {
  PENDING, CANCELLED  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"PaymentDownloadStatus\",\"namespace\":\"com.models.online.system.kafka.download.avro.model\",\"symbols\":[\"PENDING\",\"CANCELLED\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
