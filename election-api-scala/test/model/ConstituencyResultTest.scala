package model

import org.scalatest.FunSuite
import play.api.libs.json.{Json, OFormat}

class ConstituencyResultTest extends FunSuite {

  implicit val constituencyResultJson: OFormat[ConstituencyResult] = Json.format[ConstituencyResult]
  implicit val partyResultJson: OFormat[PartyResult] = Json.format[PartyResult]
  test("jsonParse") {
    val json = """{
                 |	"id": 2,
                 |	"name": "Aberconwy",
                 |	"seqNo": 1,
                 |	"partyResults": [
                 |		{
                 |			"party": "LAB",
                 |			"votes": 8994,
                 |			"share": 33.00
                 |		},
                 |		{
                 |			"party": "CON",
                 |			"votes": 7924,
                 |			"share": 29.10
                 |		},
                 |		{
                 |			"party": "LD",
                 |			"votes": 5197,
                 |			"share": 19.10
                 |		},
                 |		{
                 |			"party": "PC",
                 |			"votes": 3818,
                 |			"share": 14.00
                 |		},
                 |		{
                 |			"party": "OTH",
                 |			"votes": 517,
                 |			"share": 1.90
                 |		},
                 |		{
                 |			"party": "GRN",
                 |			"votes": 512,
                 |			"share": 1.90
                 |		},
                 |		{
                 |			"party": "UKIP",
                 |			"votes": 296,
                 |			"share": 1.10
                 |		}
                 |	]
                 |}""".stripMargin

    val jsonObj = Json.parse(json)
    val constituencyResult = Json.fromJson[ConstituencyResult](jsonObj).asOpt
    assert(constituencyResult.isDefined)

  }

}
