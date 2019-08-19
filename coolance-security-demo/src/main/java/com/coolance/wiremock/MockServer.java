package com.coolance.wiremock;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @ClassName MockServer
 * @Description Wire Mock客户端
 * @Author Coolance
 * @Version
 * @Date 2019/8/18 11:18
 */
public class MockServer {
    public static void main(String[] args) throws Exception {
        configureFor(9000);
        removeAllMappings();

        mock("/order/1", "01");
        mock("/order/2", "02");
    }

    private static void mock(String url, String file) throws Exception {
        ClassPathResource resource = new ClassPathResource("mock/response/" + file + ".txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");
        stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)));
    }
}
