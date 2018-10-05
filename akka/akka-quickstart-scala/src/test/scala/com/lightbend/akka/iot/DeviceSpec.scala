//package com.lightbend.akka.iot
//
//import akka.testkit.TestProbe
//import org.scalatest.WordSpec
//
//class DeviceSpec extends WordSpec {
//
//  "Device actor" must {
//    "reply with empty reading if no temperature is known" in {
//      val probe = TestProbe()
//      val deviceActor = system.actorOf(Device.props("group", "device"))
//
//      deviceActor.tell(Device.ReadTemperature(requestId = 42), probe.ref)
//      val response = probe.expectMsgType[Device.RespondTemperature]
//      response.requestId should ===(42)
//      response.value should ===(None)
//    }
//  }
//
//}
