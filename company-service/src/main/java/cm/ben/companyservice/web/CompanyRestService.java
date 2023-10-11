package cm.ben.companyservice.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope // rafraichie les paramettres des qu'il ya modification de valeur.
@RestController
public class CompanyRestService {
    @Value("${xParam}")
    private int xParam;
    @Value("${yParam}")
    private int yParam;
    @Value("${me}")
    private String me;

    @GetMapping("myconfig")
    public Map<String, Object> myconfig() {
        Map<String, Object> params = new HashMap();
        params.put("xParam", xParam);
        params.put("yParam", yParam);
        params.put("me", me);
        params.put("threadName", Thread.currentThread().getName()); // le nom du thread qui a envoyer les infos.
        return params;
    }

}