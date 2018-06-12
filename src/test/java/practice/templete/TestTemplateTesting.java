package practice.templete;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTemplateTesting {

    @TestTemplate
    @ExtendWith(MyTestTemplateInvocationContextProvider.class)
    void testTemplate(String parameter) {
        // MyTestTemplateInvocationContextProviderで実装したコンテキスト毎に、このテストが実行される
        // コンテキストが違うためにクラスを分けるがテストケースはほぼ一緒のような時に使えるぽい
        assertEquals(3, parameter.length());
    }
}
