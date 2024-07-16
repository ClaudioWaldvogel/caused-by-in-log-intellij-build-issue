package com.demo

import spock.lang.Specification

class CausedByInLogTest extends Specification {


    def "Caused by: manually written in log"() {
        expect:
        println("Caused by: does not matter ")
    }


    def "Caused by: in log due to nested exception"() {
        given:
        def service = new Service()

        when:
        service.callFailingExternalServiceAndLogException()

        then:
        true
    }

}


