# arep-taller6

Para realizar este taller utilizaremos la plataforma de aws para subir los servicios que utilizamos dockerizados en el
taller pasado, la idea es construir una arquitectura de la siguiente forma:

![arquitectura.png](images%2Farquitectura.png)

Para esto tenemos que crear 5 maquinas en aws, con la configuración estandar para que no generen costos,
las maquinas quedaron de la siguiente forma:

![instancias.png](images%2Finstancias.png)

Para poder usar los servicios en cada maquina tenemos que descargar java, git y maven.

![comandoinstall.png](images%2Fcomandoinstall.png)
![javainstalado.png](images%2Fjavainstalado.png)
![installgit.png](images%2Finstallgit.png)
![mvncomando.png](images%2Fmvncomando.png)

También tenemos que modificar el balanceador para que envie los servicios a cada instancia de log:

![modificacion.png](images%2Fmodificacion.png)

Por ultimo añadimos mongo a la maquina que va a hacer de base de datos y lo ejecutamos:

![mongo install.png](images%2Fmongo%20install.png)

![mongo running.png](images%2Fmongo%20running.png)

Tenemos que cambiar en cada log, para que se conecta a la base de datos nueva, una vez lo cambiemos
solo tenemos que ejecutar los servicios y podemos ver como resultado:
![servicio funcionando.png](images%2Fservicio%20funcionando.png)