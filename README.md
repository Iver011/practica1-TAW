
  ## PRACTICA I- DESARROLLO WEB BACKEND
  Parte Practica
  Creacion de las rutas GET,POST,PUT,DELETE en el controller con sus correspondientes servicios
  Cada ruta fue probada en POSTMAN
  
  ### La actualización de un estudiante existente:
    Implemente un endpoint en el controlador para actualizar un estudiante.
    Mediante PUT y obtener un estudiante por su ID con GET.
    Llama al servicio correspondiente para actualizar el estudiante.
    Devuelve Retorna el estudiante actualizado con código 200 OK.

  ### La creación un nuevo estudiante:
    Implemente un endpoint en el controlador para registrar un estudiante en el sistema.
    Asegúrate de recibir los datos en formato JSON y mapearlos correctamente a un DTO.
    Convierte el DTO en una entidad y guárdalo en el repositorio.
    Devuelve una respuesta con el estado 201 Creado si la operación es exitosa.

  ### Eliminar un estudiante por su ID:
    Implemente un endpoint en el controlador para eliminar un estudiante específico.
    Asegúrese de recibir el ID del estudiante como parámetro en la URL.
    Llama al servicio correspondiente para eliminarlo del repositorio.
    Devuelve una respuesta con el estado 204 No Content si la operación es exitosa.
