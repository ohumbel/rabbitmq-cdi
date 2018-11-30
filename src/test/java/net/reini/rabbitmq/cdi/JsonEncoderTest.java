package net.reini.rabbitmq.cdi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JsonEncoderTest {
  private Encoder<TestEvent> encoder;

  @BeforeEach
  public void setUp() {
    encoder = new JsonEncoder<>();
  }

  @Test
  public void testEncode() throws EncodeException {
    TestEvent eventObject = new TestEvent();
    eventObject.setId("theId");
    eventObject.setBooleanValue(true);
    byte[] messageBody = encoder.encode(eventObject);

    assertEquals("{\"id\":\"theId\",\"booleanValue\":true}", new String(messageBody));
    assertTrue(eventObject.isBooleanValue());
  }

  @Test
  public void testContentType() {
    assertEquals("application/json", encoder.contentType());
  }
}
