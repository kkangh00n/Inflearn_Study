package Kkangh00n.Inflearn_Study.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //MVC template 방식
    @GetMapping("hello")                    //url 매칭 -> Model로 변환
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello/hello";
        //리턴 값으로 반환한 문자를 viewresolver가
        //templates/hello.html을 찾아서 실행
    }



    //MVC template 방식
    @GetMapping("hello-mvc")                //url 매칭
    public String helloMvc(@RequestParam("name") String name1, Model model){

        //RequestParam 속 "name" = url내에 name에 대한 value!
        //String name1 = url내에 name값을 전달받을 메소드 내의 name1 !

        model.addAttribute("name2", name1);

        //attributeName의 name2 = html파일 속 전달받을 변수 name2

        return "hello/hello-template";
        //리턴 값으로 반환한 문자를 viewresolver가
        //templates/hello-template.html을 찾아서 실행
    }



    //API 방식(문자형)
    @GetMapping("hello-string")
    @ResponseBody           //http의 Body태그부에 return값을 직접 넣어줌
    public String helloString(@RequestParam("name") String name){
        return "hello" +  name;     //얘는 html이 아닌 return 데이터 값이 그대로 웹으로 전송!!
    }
    // @ResponseBody 태그가 붙어있으면 http Body태그부분에 HTTPMessageConverter(StringConverter)가 그대로 return값을 넘겨줌

    


    //API 방식(객체)
    @GetMapping("hello-api")            //ctrl + p = 파라미터 유형 볼수있음
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();          ///ctrl + shift + enter = 자동완성
        hello.setName(name);
        return hello;                   //객체 반환 = JSON 방식으로 출력
    }
    // @ResponseBody 태그가 붙어있으면 http Body태그부분에 HTTPMessageConverter(JSONConverter)가 그대로 return값을 넘겨줌
    // (JSON 방식으로 데이터를 변경하여 넘겨줌)


    static class Hello{
        private String name;

        // alt + insert : getter and setter

        public String getName() {               //alt + insert = getter, setter 단축키
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
