package com.demo;

import com.demo.config.jdbc.DatasourceEmbeddedConfig;
import com.demo.config.jdbc.JdbcConfig;
import com.demo.config.transaction.TransactionManagerConfig;
import com.demo.config.web.MvcConfig;
import java.nio.charset.StandardCharsets;
import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Servletのセットアップ処理. `web.xml`におけるListenerとServlet定義をこのClassで宣言します
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  /**
   * ContextLoaderListenerのセットアップ.
   * `web.xml`だとListenerタグでContextLoaderListerクラスを定義し、Webアプリ用のコンポーネントのConfigurationクラスをセットします.
   * (主にService, Repository, DataSourceやドメインロジックなどSpring MVCから直接参照しないBeanが対象.)
   *
   * @return Configuration Classes for Web Application.
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{
        DatasourceEmbeddedConfig.class,
        JdbcConfig.class,
        TransactionManagerConfig.class
    };
  }
  
  /**
   * DispatcherServletのセットアップ.
   * `web.xml`だとservletタグでDispatcherServletクラスを定義し、Spring MVC用のコンポーネントをConfigurationクラスをセットします.
   * (主に\@EnableWebMVCを付けたConfigurationクラスが対象.)
   * DispatcherServletはSpring MVCにおけるフロントエンドコントローラーのことでここからSpring MVCのコントローラークラスのメソッドを呼び出します.
   *
   * @return Configuration Classes for Dispatcher Servlet.
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{
        MvcConfig.class
    };
  }
  
  /**
   * ServletにマッピングするURLパターンのセットアップ.
   * `web.xml`だとservlet-mappingタグに相当し、servlet-nameに紐づいてリクエストをハンドリングするURLパターンを指定します.
   *
   * @return URL Pattern
   */
  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
  
  /**
   * Servlet Filterの登録
   * `web.xml`だとfilterタグに相当し、フィルタークラスを指定します.
   * 今回は日本語の文字化け対応としてCharacterEncodingFilterを追加し、文字エンコードをUTF-8にします.
   * (filter-mappingはonStartUpメソッドをオーバーライドして定義する必要があるがCharacterEncodingFilterは全てのリクエストを対象にするので指定しない)
   *
   * @return Servlet Filters
   */
  @Override
  protected Filter[] getServletFilters() {
    return new Filter[]{
        new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true)
    };
  }
}
