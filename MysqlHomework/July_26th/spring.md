# Spring

程序的耦合：

- 耦合：程序间的依赖关系

  包括：

  - 类之间的依赖

  - 方法间的依赖

- 解耦：降低程序间的依赖关系

实际开发中：编译器不依赖，运行时才依赖

解决思路：

1. 使用**反射**来创建对象，避免使用new关键字
2. 通过**读取配置文件**来获取要创建的对象全限定类名

**Bean**：在计算机英语中，有可重用组件的含义

**JavaBean**：用java语言编写的可重用组件

javabean  >  实体类

它就是创建我们的Service和dao对象的

1. **需要一个配置文件配置service和dao**

   - 配置文件内容：唯一标识=全限定类名(key=value)

2. **通过读取配置文件中配置的内容，反射创建对象**

   配置文件可以是**xml**也可以是**properties**

**单例对象：只被创建一次，从而类中的成员只会初始化一次。**

**多例对象：被创建多次，执行效率没有单例高**



**IOC（Map结构）**：Inversion of Control  **控制反转**   把创建对象的权力交给框架

```java
<bean id="accountService" class="全限定类名"></bean>
```

```java
public static void main(String[] args){
    //获取核心容器对象
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    //根据id获取Bean对象
    IAccountService as = (IAccountService)ac.getBean("accountService");
    IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
}
```

**ApplicationContext** 的三个常用实现类：

- **ClassPathXmlApplicationContext：**可以加载类路径下的配置文件，要求配置文件必须在类路径下
- **FileSystemXmlApplicationContext**：可以加载磁盘任意路径下的配置文件(必须有访问权限)
- **AnnotationConfigApplicationContext：**用于读取注解创建容器的

核心容器的两个接口引发的问题：

**ApplicationContext：**（单例对象适用，大部分采用此接口）在构建核心容器时，创建对象采取的策略是立即加载的方式，只要一读取完配置文件马上创建配置文件中配置的对象

**BeanFactory：**在构建核心容器时，创建对象采取的策略是延迟加载的方式，什么时候根据id获取对象了，什么时候创建对象

**Spring 对Bean的管理细节：**

1. 创建Bean的三种方式

   - **使用默认构造函数创建，在spring的配置文件中使用bean标签，配置id 和 class属性后，且没有其他属性和标签时，采用默认构造函数创建bean对象，如果没有默认构造函数，则不能创建**

   - 使用普通工厂中的方法创建对象（使用某个类中的方法创建对象，并存入spring容器）

     ```xml
     <bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"></bean>
     ```

   - 使用静态工厂中的静态方法创建对象(某个类中的静态方法创建对象，并存入spring容器)

     ```xml
     <bean id="accountService" class="club.banyuan.factory.StaticFactory" factory-method="getAccountService"></bean>
     ```

2. bean对象的作用范围

   bean的作用范围调整：

   **scope**属性：指定bean的作用范围

   - **singleton：单例，也是默认值（常用）**
   - **prototype：多例（常用）**
   - request：作用于web应用的请求范围
   - session：作用于web应用的会话范围
   - global-session：作用于集群环境的会话范围（全局会话范围），当不是集群环境时，就是session

3. bean对象的生命周期

   - 单例对象

     出生：当容器创建时对象出生

     活着：只要容器还在，对象一直活着

     死亡：容器销毁，对象消亡

     **单例对象的生命周期和容器相同**

   - 多例对象

     出生：当使用对象时spring框架创建对象

     活着：对象只要在使用过程中就一直活着

     死亡：当对象长时间不用，且没有别的对象引用时，由java的垃圾回收器回收

**spring的依赖注入**

Dependency Injection    IOC的作用：降低程序间的依赖关系（耦合）

依赖关系的管理：以后都交给了spring维护   （在当前内容需要用到其他类的对象，由spring为我们提供，我们只需要在配置文件中说明）

依赖注入：能注入的数据：

1. 基本类型和String
2. 其他bean类型（在配置文件中或者注解配置过的bean）
3. 复杂类型/集合类型

注入方式：

1. **使用构造函数注入**

   使用标签：**constructor-arg**

   标签出现的位置：bean标签内部

   标签中的属性：

   - **type**：用于指定要注入的数据的数据类型，该数据类型也是构造函数中某些参数的类型
   - **index**：用于指定要注入的数据给构造函数中指定索引位置的参数赋值，参数索引的位置是从0开始
   - **name**：用于指定给构造函数中指定名称的参数赋值（**常用**）
   - **value**：用于提供基本数据类型和String类型的数据（日期则要配置一个日期bean）
   - **ref**：用于指定其他的bean类型数据，它指的是在spring的IOC核心容器中出现的bean对象

   ```xml
   <bean id="" class="">
       <constructor-arg name="name" ref="now"></constructor-arg>
   </bean>
   <bean id="now" class="java.util.Date"></bean>
   ```

   **优势：在获取bean对象时，注入数据时必须的操作，否则对象无法创建成功**

   **弊端：改变了bean对象的实例化方式，使我们在创建对象时，如果用不到这些数据，也必须提供**

2. **使用set方法注入（常用）**

   使用的标签：**property**

   标签出现的位置：bean标签内部

   标签的属性：

   - **name：**用于指定注入时所调用的set方法名称
   - **value：**用于提供基本数据类型和String类型的数据（日期则要配置一个日期bean）
   - **ref：**用于指定其他的bean类型数据，它指的是在spring的IOC核心容器中出现的bean对象

   ```xml
   <bean id="" class="com.example.domain1">
       <property name="name" value="now"></property>
   </bean>
   
   <!--new domain1().setName(String s)-->
   <!--实例化的对象存入ioc容器-->
   ```

   **优势：创建对象时没有明确的限制，可以直接使用默认构造函数**

   **弊端：如果有某个成员必须有值，则获取对象时set方法有可能没有执行**

   注入集合或数组：**用于给list集合注入的标签有list，array，set  用于给map集合注入的标签有map  props，结构相同，标签可以互换**

   ```xml
   <bean id="" class="">
       <property name="array">
           <array>
               <value>AAA</value>
           </array>
       </property>
       <property name="list">
           <list>
           <value>BBB</value>
           </list>
       </property>
       <property name="map">
           <map>
               <entry key="123" value="213"></entry>
           </map>
       </property>
   </bean>
   ```

3. **使用注解注入**

   注解分类：

   - **用于创建对象的**

     作用和在XML配置文件中编写一个<bean>标签实现功能一样

     **@Component**：把当前类对象存入spring容器中

     **属性：value：用于指定bean的id，当不写时，默认值是当前类名且首字母变小写**

     ```xml
     <!--扫描所有包-->
     <!--在核心配置文件中搜xmlns:context-->
     <context:component-scan base-package="club.banyuan"></context:component-scan>
     ```

     **@Controller**：一般用在表现层

     **@Service：**一般用在业务层

     **@Repository**：一般用于持久层

     作用与属性与Component一样，他们三个是spring框架提供明确的三层使用的注解，使我们的三层对象更加清晰

   - **用于注入数据的**

     作用和在XML配置文件中写<property>标签作用一样

     **@Autowired**：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的的变量类型匹配，则注入成功，如果IOC中没有任何bean类型和要注入的类型匹配，则报错，**如果有多个匹配时，先按照类型圈出匹配的对象，然后按照变量名去匹配**

     出现位置：可以是变量上，也可以是方法上

     细节：在使用注解注入时，set方法不是必须的了

     **@Qualifier**：在按照类中注入的基础之上再按照名称注入。它在给类成员注入时**不能单独使用**。但是在给方法参数注入时可以

     **属性：value：用于指定注入bean的id**

     **@Resource**：直接按照bean的id注入，可以单独使用

     **属性：name：用于指定注入bean的id**

     ***以上三个注解都只能注入其他bean类型数据，基本类型和String类型无法使用，集合类型的注入只能通过XML实现***

     **@Value**：用于注入基本类型和String类型的数据

     **属性：value：用于指定数据的值，可以使用spring中的Spel(spring的el表达式)**

     **spel的写法：${表达式}**

   - 用于改变作用范围

     作用和在<bean>标签中使用scope属性实现的功能是一样的

     **@Scope**：用于指定bean的作用范围

     **属性：value：指定范围的取值，常用取值：singleton(单例，默认)   prototype(多例)**

   - 和生命周期相关(了解)

     作用和在<bean>标签中使用init-method和destroy-method作用是一样的

     **@PreDestroy**：用于指定销毁方法

     **@PostConstruct**：用于指定初始化方法
     
     ## **spring中的新注解**
   
   **@Configuration：指定当前类是配置类**
   
   细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写
   
   **@ComponentScan：用于通过注解指定spring在创建容器时要扫描的包**
   
   ```xml
   @ComponentScan(basePackages={"club.banyuan"})
   ```
   
   属性：**value**：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包,使用此注解等同于在xml中配置了：
   
   <context:component-scan base-package="club.banyuan"></>
   
   **@Bean**：**用于把当前方法的返回值作为bean对象存入spring的IOC容器中**
   
   **属性：name：用于指定bean的id。默认值是当前方法的名称**
   
   细节：当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象，查找的方式和Autowired是一样的
   
   ```java
   ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
   ```
   
   **@Import：用于导入其他配置类**
   
   属性：**value**：**用于指定其他配置类的字节码**，当使用Import注解之后，有import注解的类，就是父配置类，导入的都是子配置类(也支持并列的配置关系)
   
   **@PropertySource**：指定properties文件的位置
   
   属性：指定文件名和路径，关键字：**classpath**：表示类路径下
   
   ```java
   @PropertySource("classpath:hello.properties")
   ```
   
   ### 注意：如果类是我们自己写的，则用注解更方便
   
   ### 当测试方法执行时，没有IOC容器，就算写了Autowired注解，也无法实现注入

**spring整合junit的配置**

- 导入spring整合junit的jar包(坐标)

- 使用junit提供的一个注解，把原有的main方法替换，替换成spring提供的**@Runwith**

- 告知spring的运行器，spring的IOC创建是基于XML还是注解的，并且说明配置 

  **@ContextConfiguration** 属性：**location**：指定xml文件位置，加上classpath关键字，表示在类路径下，

  **classes：**指定注解类所在位置

  ### **当我们使用spring  5.x版本的时候，要求junit的jar必须是4.12及以上**

### AOP  

Aspect  Oriented  Programming  ：面向切面编程(使用动态代理技术)

通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术

**作用**：在程序运行期间，不修改代码的情况下对方法进行增强

优势：减少重复代码，提高开发效率，维护方便



Joinpoint(连接点)：被拦截的点，在spring中，这些点指的是方法

Pointcut(切入点)：我们要对哪些   Joinpoint进行拦截的定义

Advice(通知/增强)：拦截到  Joinpoint之后所要做的事情

通知的类型：前置通知，后置通知，异常通知，环绕通知

Introduction(引介)：特殊的通知，在不修改代码的前提下，可以在运行期为类动态地添加一些方法霍Field

Target(目标对象)：代理的目标对象

Weaving(织入)：把增强应用到目标对象来创建新的代理对象的过程

Proxy(代理)：一个类被AOP织入增强后，就产生了一个结果代理类

Asepect(切面)：切入点和通知(引介)的结合



**Spring基于XML的AOP配置**

```xml
<!-- 配置spring的IOC，把service对象配置进来 -->
<bean id="accountService" class="club.bnayuan.service.impl.AccountServiceImpl"></bean>

<!--把spring中基于XML的AOP配置步骤
	1、把通知bean交给spring管理
	2、使用aop:config标签表明开始AOP的配置
	3、使用aop:aspect标签表明配置切面
		id属性：给切面提供一个唯一标识
		ref属性：指定通知类bean的ID
	4、在aop:aspect标签的内部使用对应的标签来配置通知的类型
		aop:before  标签配置前置通知
			method属性：指定logger类中哪个方法是前置通知
			pointcut属性：指定切入点表达式，指的是对业务层中哪些方法的增强
			切入点表达式写法：关键字：execution(表达式)
							表达式：访问权限修饰符  返回值  包名.包名.包名...类名.方法名(参数列表)
							public void club.banyuan.service.impl.AccountServiceImpl.saveAccount()
							访问修饰符可以省略，返回值可以使用通配符，表示任意返回值，包名可以使用通配符表示任意包，有几级包就需要几个*.
							可以使用..表示当前包及其子包，类名和方法名都可以使用*实现统配，参数列表可以直接写数据类型，基本数据类型直接写							名称，引用数据类型写包名.类名  java.lang.String,可以使用通配符，但是必须有参数，可以使用..表示有无参数都								可，有参数是任意类型
							全通配写法：* *.*.*(..)
							实际开发中切入表达式的通常写法：切到业务层实现类下的所有方法  * club.banyuan.service.impl.*.*(..)
-->
<!--配置logger类-->
<bean id="logger" class="club.banyuan.utils.logger"></bean>
<!--配置AOP-->
<aop:config>
    <!--配置切面-->
    <aop:aspect id="logAdvice" ref="logger">
        <!--配置通知的型，并且建立通知方法和切入点的关联-->
        <aop:before method="printLogger" pointcut="execution(public void club.banyuan.service.impl.AccountServiceImpl.saveAccount())"></aop:before>
    </aop:aspect>
</aop:config>
```

通知的四种分类：

- 前置通知

  ```xml
          <aop:before method="printLogger" pointcut="execution(public void club.banyuan.service.impl.AccountServiceImpl.saveAccount())"></aop:before>
  ```

- 后置通知

  ```xml
          <aop:after-returning method="afterReturningPrintLogger" pointcut="execution(public void club.banyuan.service.impl.AccountServiceImpl.saveAccount())"></aop:after-returning>
  ```

- 异常通知

  ```xml
          <aop:after-throwing method="afterThrowingPrintLogger" pointcut="execution(public void club.banyuan.service.impl.AccountServiceImpl.saveAccount())"></aop:after-returning>
  ```

- 最终通知

  ```xml
          <aop:after method="afterPrintLogger" pointcut="execution(public void club.banyuan.service.impl.AccountServiceImpl.saveAccount())"></aop:after>
  ```

<!--配置切入点表达式，id属性用于指定表达式的唯一标识,expression属性用于指定表达式内容，此标签写在aop:aspect标签内部表示当前切面使用 还可以写在外面，则所有切面可用-->

```xml
<aop:pointcut id="pt1" expression="* club.banyuan.service.impl.*.*(..)"></aop:pointcut>
```

配置环绕通知

当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了(动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有)

ProcedingJoinPoint  接口有一个proceed() 方法，明确调用切入点方法，该接口可以做为环绕通知的方法参数

```xml
<aop:around method="" pointcut-ref="">
```

spring的环绕通知，是spring为我们提供的一种可以在代码中手动控制增强方法何时执行的方式

注解配置通知

```xml
<context:componect-scan base-package="club.banyuan"></context:componect-scan>
//配置spring开启注解AOP的支持
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
```

@Aspect：表示当前类是一个切面类

@Before("pt1()")

@After("pt1()")

@AfterReturning()

@AfterThrowing()

@Around()

不适用XML的配置方式

```java
@Configuration
@ConponentScan(basePackages="club.banyuan")
@EnableAspectJAutoProxy
public class SpringConfiguration{   
}
```

spring中的JdbcTemplate

作用:用于和数据库交互，实现对表的CRUD操作

创建该对象：

```java
public class JdbcTemplate{
    psvm{
        //准备数据源，spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/table01");
        ds.setUsername("root");
        ds.setPassword("root");
        
        //创建对象
        JdbcTemplate jt = new JdbcTemplate();
        //设置数据源
        jt.setDateSource(ds);
        jt.execute("insert into account(name,money) values("ccc",1000)");
    }
}
```

<!--配置JdbcTemplate-->

```xml
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <property name="dataSource" ref="dataSource"></property>
</bean>
```

<!--配置数据源-->

```xml
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="dirverClassName" value="com.mysql.jdbc.Driver"></property>
    <property name="url" value=""></property>
    <property name="user" value=""></property>
    <property name="password" value=""></property>
</bean>
```

```xml
<!--开启spring对注解AOP的支持-->
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
```

