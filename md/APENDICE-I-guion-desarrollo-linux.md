# APENDICE I - Guión desarrollo aplicación Java en Linux

# Instalar Java

- Eclipse (con su dependencia de Java)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
apt-get install eclipse
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- Los fuentes de Java
    - Se instalan en /usr/lib/jvm/java-6-openjdk/srz.zip
    - Utiles para debug en el Eclipse

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
apt-get install openjdk-6-source
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# Instalar MySQL

- MySQL Server

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
apt-get install mysql-server
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- MySQL Workbench
    - Descargar e instalar el paquete DEB para ubuntu:
        - <http://dev.mysql.com/downloads/workbench/>

# Otras instalaciones

- GraphViz y PlotUtils (necesarios para UMLGraph)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
apt-get install graphviz
apt-get install plotutils
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# Maven

- Instalar maven2

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
apt-get install maven2
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- Crear un proyecto:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
mvn archetype:generate
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- Construir un proyecto:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
mvn clean install site
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# Maven y Eclipse

- Para instalar un plugin en Eclipse:
    - **Help > Install New Software...**
    - <http://m2eclipse.sonatype.org/installing-m2eclipse.html>
- Nos permite:
    - crear/importar proyectos maven
    - descarga y actualiza dependencias automaticamente
    - editor visual de pom.xml
    - presentación gráfica de dependencias

# Plugins de Eclipse

- Para instalar un plugin en Eclipse:
    - **Help > Install New Software...**
- Plugins:
    - **PDM**:
        - <http://pmd.sourceforge.net/eclipse/>
    - **CheckStyle**:
        - <http://eclipse-cs.sf.net/update/>
    - **FindBugs**:
        - <http://findbugs.cs.umd.edu/eclipse/>

# Plugins de Maven (I)

- pom.xml

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<reporting>
  <plugins>
    <plugin>
      ...
    </plugin>
    <plugin>
      ...
    </plugin>
  </plugins>
</reporting>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# Plugins de Maven (II)

- UmlGraphDoc

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-javadoc-plugin</artifactId>
  <configuration>
    <show>private</show>
    <doclet>org.umlgraph.doclet.UmlGraphDoc</doclet>
    <docletArtifact>
      <groupId>org.umlgraph</groupId>
      <artifactId>doclet</artifactId>
      <version>5.1</version>
    </docletArtifact>
    <additionalparam>
      -attributes -operations -visibility -types -enumerations -enumconstants -views -hide java.*
      -inferdep -inferdepinpackage -inferdepvis -inferrel -inferreltype
    </additionalparam>
    <useStandardDocletOptions>true</useStandardDocletOptions>
  </configuration>
</plugin>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# Plugins de Maven (III)

- PMD

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-pmd-plugin</artifactId>
  <version>2.5</version>
  <configuration>
    <targetJdk>1.5</targetJdk>
  </configuration>
</plugin>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- CheckStyle

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-checkstyle-plugin</artifactId>
</plugin>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# Plugins de Maven (IV)

- FindBugs

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>findbugs-maven-plugin</artifactId>
</plugin>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- Cobertura

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>cobertura-maven-plugin</artifactId>
  <configuration>
    <formats>
      <format>html</format>
      <format>xml</format>
    </formats>
  </configuration>
</plugin>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# Sonar

- Descargar desde:
    - <http://www.sonarsource.org/downloads/>
- Descomprimir donde guste:
    - **$SONAR/**
- Ejecutar sql para crear esquema:
    - **$SONAR/extras/database/mysql/create_database.sql**
- Comentar derby y descomentar mysql en fichero de propiedades:
    - **$SONAR/conf/sonar.properties**
- Arrancar/Parar/Reiniciar el servidor:
    - **$SONAR/bin/[OS]/sonar.sh start|stop|restart**

# Sonar y Maven (I)

- Crear: **$HOME/.m2/settings.xml**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<settings>
    <profiles>
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                 <sonar.jdbc.url>
                  jdbc:mysql://localhost:3306/sonar?useUnicode=true&amp;characterEncoding=utf8
                </sonar.jdbc.url>
                <sonar.jdbc.driverClassName>com.mysql.jdbc.Driver</sonar.jdbc.driverClassName>
                <sonar.jdbc.username>sonar</sonar.jdbc.username>
                <sonar.jdbc.password>sonar</sonar.jdbc.password>
                <sonar.host.url>http://localhost:9000</sonar.host.url>
            </properties>
        </profile>
     </profiles>
</settings>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# Sonar y Maven (II)

- En la carpeta del proyecto

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
mvn sonar:sonar
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- Ir a un navegador:
    - <http://localhost:9000>

# Sonar y Eclipse

- Para instalar un plugin en Eclipse:
    - **Help > Install New Software...**
    - <http://dist.sonar-ide.codehaus.org/eclipse/>
- Enlazar un proyecto:
    - Botón derecho en la carpeta del proyecto: **Configure > Associate with Sonar...**

# Enlazar URL proyectos con Sonar:

- Instalar **Tomcat**: (valdría también Apache)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
apt-get install tomcat6
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- Enlace simbólico del workspace de **Eclipse** al webapps de Tomcat:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
sudo ln -s $HOME/workspace /var/lib/tomcat6/webapps/
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- modificar URL del proyecto en su **pom.xml**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<url>http://localhost:8080/workspace/NOMBRE-PROYECTO/target/site/...html</url>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
