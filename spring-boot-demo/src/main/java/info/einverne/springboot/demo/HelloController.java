package info.einverne.springboot.demo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * 注解 @RestController 是 @Controller 和 @ResponseBody 的结合
 * Controller 中的每一个方法都是返回 rest object 而不是 View
 */
@RestController
public class HelloController {

    @Value("${key.hello}")
    private String hello;

    @Autowired
    private Person person;

    @ApiOperation(value = "hello api name 接口名字", notes = "api detail desc 接口具体定义")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "world " + hello;
    }

    @ApiOperation(value = "hello1 api name", notes = "api detail desc")
    @ApiImplicitParam(name = "value", value = "传入参数 string", required = true, dataType = "String")
    @RequestMapping(value = "/hello1", method = RequestMethod.POST)
    public String hello1(@RequestBody HelloRequest value) {
        return "world " + value.getValue();
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String person() {
        return "person info: " + person.getName() + " " + person.getAge();
    }
}
