## Spring Boot Framework
* Spring Boot = Spring++, Spring Boot framework is built on top of Spring framework
* Spring Boot is Spring without XML Configurations and with auto configuration annotations i.e based on the starters (jar files) added, spring boot 
  takes care of multiple common and necessary operations.
* Starters have capability to perform autoconfiguration activities required by the application like:
  * Configuring certain java classes as spring beans
  * Performing dependency injections among spring beans
  * Providing dependant and relevant jar files
  * Providing embedded database servers (H2 database)
  * Gives Database connectivity configurations
  * Providing embedded application servers (Apache Tomcat)
  * Supplies necessary plugins required for maven or gradle tools
* @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
  * @Configuration/@SpringBootConfiguration: Makes java classes as spring beans and configuration class where other java classes
     can be configured as spring beans (it is alternate to applicationConfiguration.xml file)
  * @EnableAutoConfiguration: This annotation makes the spring boot framework to perform autoconfiguration i.e based on starters
     added it will do lots of common things including giving certain pre-defined classes as spring beans and performing injections
     among them.
  * @ComponentScan: Takes all the java classes marked with stereo type annotations from the current package and its sub package
     to make them as spring beans automatically.
    * Three Thumb rules to remember while working with Spring boot framework
    > 1. Configure user-defined classes as spring beans using stereo type annotations.
    > 2. Configure pre-defined classes as spring beans using @Bean methods in @SpringBootApplication class if they are not
        coming as spring beans through AutoConfiguration based on the spring boot starters that are added.
       <br> Note: We can give inputs and we can also override defaults of AutoConfiguration with the support of application.properties/yml file
    > 3. In main method of @SpringBootApplication class, get IOC container by calling SpringApplication.run(,) method and use
       the getBean() method of the IOC container for getting required spring bean.
* In Core programming of Spring Boot applications, we use the following categories of annotations:
  * Annotations for configuration
    1. @Component
    2. @Service
    3. @Repository
    4. @Controller : makes a user-defined class a spring bean and also a web controller class
    5. @RestController : makes a user-defined class a spring bean, a web controller class, and also a REST API component
    6. @ControllerAdvice: makes user-defined class a spring bean and also exception handler class in REST API
    7. @Configuration : this annotation is used indirectly through @SpringBootApplication
    8. @Bean
    * All the above annotations are specific to spring framework
  * Annotations for Data Supply
    1. @Autowired
    2. @Value
    3. @Qualifier and @Primary
    * The above three are specific to spring framework
    * Here, are the java config annotations (given by jdk, jee apis and can be used in any frameworks)
    1. @Named : to resolve java class as spring bean and also resolve ambiguity problem (it is like @Component + @Qualifier)
    2. @Inject: works like @Autowired
    3. @Resource: works like @Autowired + @Qualifier
    * These java config annotations make the code more non-invasive because, they are not specific to spring or any framework
      so moving the code to a framework better than spring is easy
    * In realtime application development we are not using java config annotations because they are very few not enough to
     develop a serious real time application
  * Annotations for Spring Bean Life Cycle
    * @PostConstruct and @PreDestroy
  * Misc Annotations
    * @PropertySource, @ComponentScan, @ImportSource, @Scope, @Lazy, @Import, etc
  * 