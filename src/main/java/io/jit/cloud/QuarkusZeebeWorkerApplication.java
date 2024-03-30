package io.jit.cloud;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.quarkiverse.zeebe.JobWorker;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@Slf4j
public class QuarkusZeebeWorkerApplication {

  public static final String EXTERNAL_TASK_TYPE = "orchestrate-something";

  @JobWorker(type = EXTERNAL_TASK_TYPE)
  public Map<String, Object> publishTweet(final ActivatedJob job) {
    // Do the business logic
    System.out.println("Yeah, now you can orchestrate something :-) You could use data from the process variables: " + job.getVariables());

    // Probably add some process variables
    HashMap<String, Object> variables = new HashMap<>();
    variables.put("resultValue1", 42);
    return variables;
  }

}
