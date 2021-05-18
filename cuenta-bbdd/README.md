# Gestion de Cuenta (MVC)

Realiza una aplicación general, en modo texto, para realizar una conexión a una base de datos y poder lanzarle órdenes de cualquier tipo. 
Ten en cuenta que debe ser reutilizable y personalizable. Se podrán ejecutar sentencias SELECT, UPDATE, INSERT y DELETE.
Se pretende realizar una aplicación en Java capaz de gestionar la información de una base de datos de un banco almacenadas en una tabla de una base de datos cuya estructura es la siguiente. 
Tabla cuenta:
 * codigo: String (varchar 50).
 * cliente: String (varchar 9).
 * email: String (varchar 50).
 * saldo: double.

La aplicación tiene que ser capaz de realizar las tareas de alta, baja, modificación y consulta de los datos de las cuentas. Las consultas se podrán hacer tanto por código de la cuenta como por el identificador del cliente. Recuerda seguir la arquitectura mvc.

