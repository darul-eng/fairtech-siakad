package siakad

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class AuthMiddlewareInterceptorSpec extends Specification implements InterceptorUnitTest<AuthMiddlewareInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test authMiddleware interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"authMiddleware")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
