# edu.rest-doc

# Steps to recreate problem
1. Run test in `HelloControllerTest` or `WeblayerTestDoc`. Both should pass.
2. Check if snippets are generated.  You should see it under `build/generated-snippets`
3. Go to terminal `gradle asciidoctor` or `gradle asciidoctor -t`
4. **Problem!** snippets gone!


# Gradle tasks

`gradle asciidoctor --console=plain`  results...

```bash
> Task :compileJava
> Task :processResources
> Task :classes
> Task :compileTestJava
> Task :processTestResources NO-SOURCE
> Task :testClasses
> Task :test

> Task :asciidoctor
asciidoctor: WARNING: api.adoc: line 3: include file not found: /Users/erichuang/Desktop/JE/00-Development/dev/lab/lab-rest-docs/lab.restdocs-gradlebuild/build/generated-snippets/home/curl-request.adoc
asciidoctor: WARNING: api.adoc: line 5: include file not found: /Users/erichuang/Desktop/JE/00-Development/dev/lab/lab-rest-docs/lab.restdocs-gradlebuild/build/generated-snippets/home/http-request.adoc
asciidoctor: WARNING: api.adoc: line 7: include file not found: /Users/erichuang/Desktop/JE/00-Development/dev/lab/lab-rest-docs/lab.restdocs-gradlebuild/build/generated-snippets/home/http-response.adoc
asciidoctor: WARNING: api.adoc: line 20: include file not found: /Users/erichuang/Desktop/JE/00-Development/dev/lab/lab-rest-docs/lab.restdocs-gradlebuild/build/generated-snippets/home-json/http-response.adoc

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.5/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 2s
5 actionable tasks: 5 executed
Apples-MBP:lab.restdocs-gradlebuild erichuang$ 
```




# Resources
* https://docs.spring.io/spring-restdocs/docs/2.0.5.RELEASE/reference/html5/#getting-started-build-configuration
* https://spring.io/guides/gs/testing-restdocs/
* https://www.youtube.com/watch?v=k5ncCJBarRI&t=1446s