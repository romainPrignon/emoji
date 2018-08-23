package core

import org.scalatest.FunSpec

// under test
import core.Main.emoji

class CoreSpec extends FunSpec {
  describe("core") {
    describe("Main") {
      describe("emoji") {
        it("emoji: should return ❤ from word 'love'") {
            // given

            // when
            val res = emoji("love")

            // then
            res.fold(
                l => assert(l == None),
                r => r.fold(
                    l => assert(l == None),
                    r => {
                        assert(r == "❤️")
                    }
                )
            )
        }
      }
    }
  }
}

//   it("should produce NoSuchElementException when head is invoked") {
    //     assertThrows[NoSuchElementException] {
    //       Set.empty.head
    //     }
    //   }