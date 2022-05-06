package hello.advanced.trace.helloTrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;


class HelloTraceV1Test {

    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }

}