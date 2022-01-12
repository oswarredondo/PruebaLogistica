/**
 * ServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public interface ServiceSoap extends java.rmi.Remote {

    /**
     * Retorna los IDs de las Guias de Liquidación
     */
    public int[] obtenerIdsGuiasLiquidacion(java.lang.String apiKey, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String codigoSucursal, ar.com.unisolutions.PVehiculo vehiculo, ar.com.unisolutions.PTransporte transporte, ar.com.unisolutions.PConductor conductor, java.lang.String estadoGuias, java.lang.String tipoGuia, java.lang.String codigoOperacion) throws java.rmi.RemoteException;

    /**
     * Retorna las guias de liquidacion
     */
    public ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacionPorId(java.lang.String apiKey, int[] idsGuias) throws java.rmi.RemoteException;

    /**
     * Retorna las guias de liquidacion
     */
    public ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacion(java.lang.String apiKey, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String codigoSucursal, ar.com.unisolutions.PVehiculo vehiculo, ar.com.unisolutions.PTransporte transporte, ar.com.unisolutions.PConductor conductor, java.lang.String estadoGuias, java.lang.String tipoGuia, java.lang.String codigoOperacion) throws java.rmi.RemoteException;

    /**
     * Retorna las guias de liquidacion
     */
    public ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacion2(ar.com.unisolutions.ObtenerGuiasLiquidacionRequest request) throws java.rmi.RemoteException;

    /**
     * Retorna las guias de liquidacion
     */
    public ar.com.unisolutions.PGuiaLiquidacion[] obtenerGuiasLiquidacionAvanzado(java.lang.String apiKey, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String codigoSucursal, ar.com.unisolutions.PVehiculo vehiculo, ar.com.unisolutions.PTransporte transporte, ar.com.unisolutions.PConductor conductor, java.lang.String tipoGuia, java.lang.String viaje_ReferenciaExterna, int idViaje) throws java.rmi.RemoteException;

    /**
     * Modifica el estado de una Guia
     */
    public int modificarEstadoGuia(java.lang.String apiKey, ar.com.unisolutions.PEstadoGuia estado) throws java.rmi.RemoteException;

    /**
     * Modifica el estado de una liquidacion
     */
    public int modificarEstadoLiquidacion(java.lang.String apiKey, ar.com.unisolutions.PEstadoLiquidacion estado) throws java.rmi.RemoteException;

    /**
     * Crea guias de liquidacion
     */
    public int crearGuiasLiquidacion(java.lang.String apiKey, ar.com.unisolutions.PGuiaLiquidacion[] guias) throws java.rmi.RemoteException;

    /**
     * Agrega paradas a un viaje
     */
    public ar.com.unisolutions.AgregarParadaViajeResponse[] agregarParadaViaje(java.lang.String apiKey, int idViaje, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException;

    /**
     * Crea documentos
     */
    public int crearDocumentos(java.lang.String apiKey, ar.com.unisolutions.PDocumento[] documentos) throws java.rmi.RemoteException;

    /**
     * Baja lógica de documentos
     */
    public int eliminarDocumento(java.lang.String apiKey, java.lang.String referencia) throws java.rmi.RemoteException;

    /**
     * Modifica el valor de las tarifas no formula
     */
    public int modificarTarifas(java.lang.String apiKey, ar.com.unisolutions.PTarifa[] tarifas) throws java.rmi.RemoteException;

    /**
     * Crea / modifica recursos.
     */
    public int crearRecursos(java.lang.String apiKey, ar.com.unisolutions.PRecurso[] recursos) throws java.rmi.RemoteException;

    /**
     * Baja lógica de recursos.
     */
    public int eliminaRecurso(java.lang.String apiKey, java.lang.String referenciaRecurso) throws java.rmi.RemoteException;

    /**
     * Consultar recursos.
     */
    public ar.com.unisolutions.PRecursoExtended[] consultarRecursos(java.lang.String apiKey, ar.com.unisolutions.ConsultarRecursosRequest consultarRecursos) throws java.rmi.RemoteException;

    /**
     * Crea / modifica Custodios.
     */
    public int crearEmpresasCustodia(java.lang.String apiKey, ar.com.unisolutions.PEmpresaCustodia[] empresas) throws java.rmi.RemoteException;

    /**
     * Crea / modifica Custodios.
     */
    public int crearCustodios(java.lang.String apiKey, ar.com.unisolutions.PCustodio[] custodios) throws java.rmi.RemoteException;

    /**
     * Crea / modifica Conductores.
     */
    public int crearConductores(java.lang.String apiKey, ar.com.unisolutions.PConductor[] conductores) throws java.rmi.RemoteException;

    /**
     * Crea / modifica Transportistas.
     */
    public int crearTransportes(java.lang.String apiKey, ar.com.unisolutions.PTransporte[] transportes) throws java.rmi.RemoteException;

    /**
     * Crea / modifica Clientes dadores.
     */
    public int crearClientesDadores(java.lang.String apiKey, ar.com.unisolutions.PClienteDador[] clientes) throws java.rmi.RemoteException;

    /**
     * Crea / modifica Propietarios.
     */
    public int crearPropietarios(java.lang.String apiKey, ar.com.unisolutions.PPropietario[] propietarios) throws java.rmi.RemoteException;

    /**
     * Cambia estado de entidades.
     */
    public ar.com.unisolutions.BooleanResponse cambiarEstado(java.lang.String entidad, java.lang.String referenciaExterna, int idEntidad, int idEstado, java.lang.String apiKey) throws java.rmi.RemoteException;

    /**
     * Carga codigos de control.
     */
    public int crearCodigosControl(java.lang.String apiKey, ar.com.unisolutions.PCodigoControl[] codigos) throws java.rmi.RemoteException;

    /**
     * Crea una Ruta
     */
    public int crearRuta(java.lang.String apiKey, ar.com.unisolutions.PRuta ruta) throws java.rmi.RemoteException;

    /**
     * Create / Modify Deposits.
     */
    public int createDeposits(java.lang.String apiKey, ar.com.unisolutions.PDeposito[] deposits) throws java.rmi.RemoteException;

    /**
     * Modifica una Ruta
     */
    public int modificarRuta(java.lang.String apiKey, ar.com.unisolutions.PRuta ruta) throws java.rmi.RemoteException;

    /**
     * Elimina de forma Logica Domicilios Orden
     */
    public int eliminarDomiciliosOrden(java.lang.String apiKey, ar.com.unisolutions.PCliente[] datos) throws java.rmi.RemoteException;

    /**
     * Busca los viajes Activos del domicilio orden y los finalizados
     * e inactivos del dia de la fecha.
     */
    public ar.com.unisolutions.PViaje[] consultarViajesPorDomicilioOrden(java.lang.String apiKey, ar.com.unisolutions.ConsultarViajeRequest consulta) throws java.rmi.RemoteException;

    /**
     * Modifica Paradas Existentes.
     */
    public int modificarParadas(java.lang.String apikey, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException;
    public ar.com.unisolutions.ConsultarEtiquetasResponse consultarEtiquetas(java.lang.String apikey, ar.com.unisolutions.ConsultarEtiquetasRequest request) throws java.rmi.RemoteException;
    public ar.com.unisolutions.PEmpresa consultarEmpresaOperacion(ar.com.unisolutions.ConsultarEmpresaOperacionRequest request) throws java.rmi.RemoteException;

    /**
     * Modifica Remitos.
     */
    public int modificarRemito(java.lang.String apikey, ar.com.unisolutions.PClienteDador clienteDador, ar.com.unisolutions.PRemito remito) throws java.rmi.RemoteException;

    /**
     * Consulta estados de paradas en viaje.
     */
    public ar.com.unisolutions.PEstadosViaje consultarEstadosParadasViaje(java.lang.String apikey, int idViaje) throws java.rmi.RemoteException;

    /**
     * Cambia estado de recursos.
     */
    public ar.com.unisolutions.BooleanResponse cambiarEstadoRecurso(java.lang.String apikey, java.lang.String entidad, java.lang.String referenciaExterna, int idEntidad, java.lang.String estado, java.lang.String login, java.lang.String motivo, boolean validarTransicion, boolean mismoEstado, java.lang.String observaciones) throws java.rmi.RemoteException;

    /**
     * Modificar el estado de un viaje asociando archivos al cambio
     * de estado
     */
    public int modificarEstadoViajeArchivos(java.lang.String apiKey, ar.com.unisolutions.PEstadoViaje cambio) throws java.rmi.RemoteException;

    /**
     * Modificar el estado de un viaje
     */
    public int modificarEstadoViaje(java.lang.String apiKey, int idViaje, java.lang.String estado, java.lang.String login, boolean validarTransicion, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException;

    /**
     * Modifica el estado de una Ruta
     */
    public int modificarEstadoRuta(java.lang.String apiKey, int idRuta, java.lang.String estado, java.lang.String login, boolean validarTransicion) throws java.rmi.RemoteException;

    /**
     * Obtiene los viajes para una fecha determinada con la opción
     * de filtrar por sucursal y operación. En caso de ingresar una operacion,
     * se debe ingresar una sucursal
     */
    public ar.com.unisolutions.PViaje[] obtenerViajes(java.lang.String apiKey, java.util.Calendar fecha, java.lang.String codigoOperacion, java.lang.String codigoSucursal) throws java.rmi.RemoteException;
    public java.util.Calendar testTimeZone(java.util.Calendar dt, java.lang.String apiKey) throws java.rmi.RemoteException;
    public ar.com.unisolutions.PEstadiaParada[] obtenerEstadias(java.lang.String apiKey, java.util.Calendar desde, java.util.Calendar hasta, java.lang.String timeZone) throws java.rmi.RemoteException;

    /**
     * Permite agregar encuestas a viaje o parada
     */
    public ar.com.unisolutions.BooleanResponse agregarEncuestas(java.lang.String apiKey, java.lang.String login, ar.com.unisolutions.PEncuesta[] encuestas) throws java.rmi.RemoteException;

    /**
     * Permite crear benificiarios para un transporte
     */
    public int crearBeneficiariosTransporte(java.lang.String apiKey, ar.com.unisolutions.PBeneficiario[] beneficiarios) throws java.rmi.RemoteException;

    /**
     * Consultar validez api key
     */
    public boolean apiKeyValida(java.lang.String s) throws java.rmi.RemoteException;

    /**
     * Metodo de test para crear un viaje, no aplica en test o produccin
     */
    public int dummyCrearViaje(java.lang.String apiKey) throws java.rmi.RemoteException;

    /**
     * Crea un viaje, sincronizando maestros y creando seguimiento
     * para control
     */
    public int crearViaje(java.lang.String apiKey, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException;

    /**
     * Crea un viaje, sincronizando maestros y creando seguimiento
     * para control. 
     *         Sincroniza tambien vehiculo en caso de existir el prestador
     */
    public int crearViaje2(java.lang.String apiKey, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, java.lang.String prestador, java.lang.String varchar1, java.lang.String varchar2, java.lang.String varchar3, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException;

    /**
     * Crea un viaje, sincronizando maestros y creando seguimiento
     * para control. 
     *         Sincroniza tambien Empresa, sucursal, operación y vehiculo
     * en caso de existir el prestador
     */
    public int crearViaje3(java.lang.String apiKey, java.lang.String empresa, java.lang.String sucursal, java.lang.String operacion, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, java.lang.String prestador, java.lang.String varchar1, java.lang.String varchar2, java.lang.String varchar3, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException;

    /**
     * Crea un viaje, sincronizando maestros y creando seguimiento
     * para control. 
     *         Sincroniza tambien Empresa, sucursal, operación y vehiculo
     * en caso de existir el prestador
     */
    public ar.com.unisolutions.CrearViajeResultado crearViaje4(java.lang.String apiKey, java.lang.String empresa, java.lang.String sucursal, java.lang.String operacion, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, java.lang.String prestador, java.lang.String varchar1, java.lang.String varchar2, java.lang.String varchar3, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException;

    /**
     * Crea un viaje, a partir de un Tipo de Operación, y los Depósitos.
     */
    public ar.com.unisolutions.CrearViajeResultado crearViaje5(java.lang.String apiKey, java.lang.String empresa, java.lang.String sucursal, java.lang.String tipoOperacion, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException;

    /**
     * Crea un viaje, sincronizando maestros y creando seguimiento
     * para control. 
     *         Sincroniza tambien Empresa, sucursal, operación y vehiculo
     * en caso de existir el prestador. Permite asignar el recorrido dinamicamente
     */
    public ar.com.unisolutions.CrearViajeResultado crearViaje6(java.lang.String apiKey, java.lang.String empresa, java.lang.String sucursal, java.lang.String operacion, java.lang.String recorrido, java.lang.String dominio, java.util.Calendar fechaViaje, java.lang.String referencia, java.lang.String observaciones, ar.com.unisolutions.Transporte transporte, ar.com.unisolutions.PCliente cliente, ar.com.unisolutions.PDeposito depositoSalida, ar.com.unisolutions.PDeposito depositoLlegada, ar.com.unisolutions.PConductor conductor, java.lang.String login, java.lang.String prestador, java.lang.String varchar1, java.lang.String varchar2, java.lang.String varchar3, ar.com.unisolutions.PParada[] paradas) throws java.rmi.RemoteException;

    /**
     * Concentra los métodos de creación de viajes (CrearViaje, CrearViaje2,
     * CrearViaje3, CrearViaje4, CrearViaje5, CrearViaje6),
     *             especificando en el parámetros ‘CrearViajeNumero’ el número
     * de método a utilizar.
     */
    public ar.com.unisolutions.CrearViajeResultado crearViajeCompleto(ar.com.unisolutions.CrearViajeSolicitud crearviaje) throws java.rmi.RemoteException;

    /**
     * Reordena un viaje utilizando transito
     */
    public void reordenarViajeTransito(java.lang.String apiKey, int idViaje, int optSize) throws java.rmi.RemoteException;

    /**
     * Anula un viaje si su estado lo permite
     */
    public boolean anularViaje(java.lang.String apiKey, int idViaje, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException;

    /**
     * Finaliza un viaje
     */
    public boolean finalizarViaje(java.lang.String apiKey, int idViaje, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException;

    /**
     * Activa un viaje
     */
    public boolean activarViaje(java.lang.String apiKey, int idViaje, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException;

    /**
     * Relaciona dos viajes considerando su tipo de relacion y rango
     * de fechas
     */
    public boolean relacionarViajes(java.lang.String apiKey, int idViaje1, int idViaje2, java.lang.String tipoRelacion, java.util.Calendar desde, java.util.Calendar hasta) throws java.rmi.RemoteException;

    /**
     * Modificar el estado de la orden de entrega
     */
    public int modificarEstadoOrdenEntrega(java.lang.String apiKey, ar.com.unisolutions.PEstadoOrdenEntrega estado) throws java.rmi.RemoteException;

    /**
     * Modificar el estado de la orden de pedido
     */
    public int modificarEstadoOrdenPedido(java.lang.String apiKey, ar.com.unisolutions.PEstadoOrdenPedido estado) throws java.rmi.RemoteException;

    /**
     * Consultar Orden de Pedido
     */
    public ar.com.unisolutions.POrdenPedido consultarOrdenPedido(java.lang.String apiKey, java.lang.String referenciaExterna) throws java.rmi.RemoteException;

    /**
     * Consultar Orden de Pedido IdPedido
     */
    public ar.com.unisolutions.POrdenPedido consultarOrdenPedidoId(java.lang.String apiKey, int idPedido) throws java.rmi.RemoteException;

    /**
     * Consultar Orden de Pedido por criterios de busqueda
     */
    public ar.com.unisolutions.POrdenPedido[] consultarOrdenesPedido(ar.com.unisolutions.ConsultarOrdenesPedidoRequest request) throws java.rmi.RemoteException;

    /**
     * Consultar Orden de Entrega
     */
    public ar.com.unisolutions.POrdenEntrega consultarOrdenEntrega(java.lang.String apiKey, java.lang.String refDocumento, java.lang.String sucursal, java.lang.String operacion, java.lang.String tipoOperacion) throws java.rmi.RemoteException;

    /**
     * Modificar el estado de la parada
     */
    public int modificarEstadoParada(java.lang.String apiKey, ar.com.unisolutions.PEstadoParada estado) throws java.rmi.RemoteException;

    /**
     * Modificar Parada Item usando la Jornada a partir de la Fecha
     */
    public int modificarParadaItem(java.lang.String apiKey, java.lang.String referenciaExternaParada, ar.com.unisolutions.PParadaItem item, java.util.Calendar fecha, java.lang.String sucursal, java.lang.String operacion) throws java.rmi.RemoteException;

    /**
     * Agregar Items a una parada a partir del IdViaje y la ReferenciaExterna
     */
    public int agregarParadaItem(java.lang.String apiKey, int idViaje, java.lang.String referenciaExternaParada, ar.com.unisolutions.ParadaItem[] items) throws java.rmi.RemoteException;

    /**
     * Modificar Parada Item usando la Jornada a partir del Viaje
     */
    public int modificarParadaItemDesdeViaje(java.lang.String apiKey, java.lang.String referenciaExternaParada, ar.com.unisolutions.PParadaItem item, java.util.Calendar fecha, java.lang.String sucursal, java.lang.String operacion, int idViaje) throws java.rmi.RemoteException;

    /**
     * Eliminar Parada Item usando la Jornada a partir del Viaje
     */
    public int eliminarParadaItemDesdeViaje(java.lang.String apiKey, java.lang.String referenciaExternaParada, java.lang.String referenciaExternaItem, java.util.Calendar fecha, java.lang.String sucursal, java.lang.String operacion, int idViaje) throws java.rmi.RemoteException;

    /**
     * Eliminar Parada Item usando la Jornada a partir de la Fecha
     */
    public int eliminarParadaItem(java.lang.String apiKey, java.lang.String referenciaExternaParada, java.lang.String referenciaExternaItem, java.util.Calendar fecha, java.lang.String sucursal, java.lang.String operacion) throws java.rmi.RemoteException;

    /**
     * Consultar el estado de la parada
     */
    public ar.com.unisolutions.ConsultarParadaResultado consultarParadaPorId(java.lang.String apiKey, int idParada) throws java.rmi.RemoteException;

    /**
     * Consultar paradas por fechas de estado incluyendo los archivos
     * de POD
     */
    public ar.com.unisolutions.ConsultarParadaEstadosResultado consultarParadaTraceEstado(java.lang.String apiKey, int idParada, java.lang.String refDocumento, java.lang.String estadoParada, java.lang.String tipoFecha, java.util.Calendar fecha, java.lang.String ignorarEstadoParada) throws java.rmi.RemoteException;

    /**
     * Consultar el estado de la parada
     */
    public ar.com.unisolutions.ConsultarParadaResultado consultarParada(java.lang.String apiKey, int idViaje, int secuencia, java.lang.String refDocumento, java.lang.String refDocumentoAdicional, java.lang.String refCliente) throws java.rmi.RemoteException;

    /**
     * Consulta el histórico de las transiciones de estado que ha
     * tenido un viaje
     */
    public ar.com.unisolutions.ConsultarViajeResultadoBasic[] consultarTransicionesEstadoViaje(java.util.Calendar fecha, java.lang.String apiKey, int idViaje, java.lang.String referenciaExterna, java.lang.String operacion, java.lang.String estadoViaje, java.lang.String tipoFecha) throws java.rmi.RemoteException;

    /**
     * Consulta los viajes que hayan registrado el cambio de estado
     * indicado en el rango de fechas
     */
    public ar.com.unisolutions.ConsultarViajeResponse[] consultarViajesPorTransicion(java.lang.String apiKey, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion, java.lang.String estadoViaje) throws java.rmi.RemoteException;

    /**
     * Consultar el estado del viaje por idViaje
     */
    public ar.com.unisolutions.ConsultarViajeResultado consultarViaje(java.lang.String apiKey, int idViaje) throws java.rmi.RemoteException;

    /**
     * Consultar el estado del viaje por rango de fechas
     */
    public ar.com.unisolutions.ConsultarViajeResultado[] consultarViajePorFechas(java.lang.String apiKey, java.util.Calendar fechaJornadaDesde, java.util.Calendar fechaJornadaHasta, int pagina, boolean cargarParadas, boolean cargarItems, boolean cargarIncidencias, boolean cargarRecursos, boolean cargarEstadoParada, boolean cargarUltimaParadaVisitada, boolean cargarTransporte) throws java.rmi.RemoteException;

    /**
     * Consultar el estado del viaje por ReferenciaExterna
     */
    public ar.com.unisolutions.ConsultarViajeResultado[] consultarViajeReferenciaExterna(java.lang.String apiKey, java.lang.String referenciaExterna) throws java.rmi.RemoteException;

    /**
     * Consultar el estado del viaje por ReferenciaExterna y Fecha
     * Jornada
     */
    public ar.com.unisolutions.ConsultarViajeResultado[] consultarViajeReferenciaExternaFechaJornada(java.lang.String apiKey, java.lang.String referenciaExterna, java.util.Calendar fechaViaje) throws java.rmi.RemoteException;
    public int modificarViaje(java.lang.String apiKey, ar.com.unisolutions.PViaje viaje, java.lang.String cambioMismoEstado, java.lang.String validarTransicion, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException;
    public int modificarViajeConParadas(java.lang.String apiKey, ar.com.unisolutions.PViaje viaje, java.util.Calendar fechaCambioEstado) throws java.rmi.RemoteException;

    /**
     * Cambiar el vehiculo asignado el viaje
     */
    public boolean cambiarVehiculoViaje(java.lang.String apiKey, int idViaje, java.lang.String referenciaExterna, java.lang.String dominio) throws java.rmi.RemoteException;

    /**
     * Retorna información general del vehículo/recurso
     */
    public ar.com.unisolutions.PRecursoVehiculo[] consultarRecursoVehiculo(java.lang.String apiKey, java.lang.String dominio, java.lang.String referenciaRecurso, java.lang.String estado, java.lang.String estadoRecurso, java.util.Calendar fechaCreacion, java.util.Calendar fechaEstadoRecurso, java.util.Calendar fechaModificacion) throws java.rmi.RemoteException;

    /**
     * Retorna la cantidad de vehiculos con la identificacion indicada,
     * pueden existir mas de uno con prestadores distintos
     */
    public int consultarVehiculo(java.lang.String apiKey, java.lang.String dominio) throws java.rmi.RemoteException;

    /**
     * Retorna una URL de mapa con la ultima posicion del vehiculo
     * en forma batch.
     */
    public ar.com.unisolutions.ConsultarMapaVehiculoResultado[] consultarMapaVehiculoBatch(java.lang.String apiKey, boolean devolverMapa, boolean devolverGeoReversa, boolean devolverTimeZone) throws java.rmi.RemoteException;

    /**
     * Retorna una URL de mapa con la ultima posicion del vehiculo.
     */
    public ar.com.unisolutions.ConsultarMapaVehiculoResultado consultarMapaVehiculo(java.lang.String apiKey, java.lang.String dominio, boolean devolverMapa, boolean devolverGeoReversa, boolean devolverTimeZone) throws java.rmi.RemoteException;

    /**
     * Recalcula el viaje
     */
    public boolean calcularViaje(int idViaje, boolean mantenerSecuencia, java.lang.String apiKey) throws java.rmi.RemoteException;

    /**
     * Testea conexion con DB
     */
    public boolean testDBConnection(java.lang.String apiKey) throws java.rmi.RemoteException;

    /**
     * Obtiene las ordenes de la ruta solicitada
     */
    public ar.com.unisolutions.POrdenEntrega[] obtenerRuta(java.lang.String apiKey, int idJornada, int idRuta) throws java.rmi.RemoteException;
    public int crearClientesOrden(ar.com.unisolutions.PCliente[] clientes, java.lang.String codigoSucursal, java.lang.String codigoOperacion, java.lang.String apiKey) throws java.rmi.RemoteException;

    /**
     * Recibe la información de órdenes de pedidos. Recibe y sincroniza
     * los maestros de clientes y domicilios.
     */
    public int crearOrdenesPedido(java.lang.String apiKey, ar.com.unisolutions.POrdenPedido[] pedidos) throws java.rmi.RemoteException;

    /**
     * Servicio de Creación de Productos
     */
    public int crearProductos(java.lang.String apiKey, ar.com.unisolutions.PProducto[] productos) throws java.rmi.RemoteException;

    /**
     * Elimina órdenes de pedido. No elimina maestros.
     */
    public int eliminarOrdenesPedido(java.lang.String apiKey, ar.com.unisolutions.POrdenPedido[] pedidos) throws java.rmi.RemoteException;

    /**
     * Recibe la información necesaria para crear un remito asociado
     * a una órden
     */
    public int crearRemito(java.lang.String apiKey, ar.com.unisolutions.PRemito remito) throws java.rmi.RemoteException;

    /**
     * Recibe la información de órdenes de entregas para realizar
     * su planificación de ruteo.
     *         Recibe y sincroniza los maestros de clientes y domicilios.
     */
    public int crearOrdenesEntrega(java.lang.String apiKey, ar.com.unisolutions.POrdenEntrega[] entregas) throws java.rmi.RemoteException;

    /**
     * Elimina órdenes de entrega. No elimina maestros.
     */
    public int eliminarOrdenesEntrega(java.lang.String apiKey, ar.com.unisolutions.POrdenEntrega[] entregas) throws java.rmi.RemoteException;

    /**
     * Crea los vehículos para ser utilizados en el seguimiento satelital
     * y asignación de vehículos a viajes.
     */
    public int crearVehiculos(java.lang.String apiKey, ar.com.unisolutions.PVehiculo[] vehiculos) throws java.rmi.RemoteException;

    /**
     * Crea los vehículos para ser utilizados en el seguimiento satelital
     * y asignación de vehículos a viajes.
     */
    public int crearVehiculos_ValidarExistencia(java.lang.String apiKey, ar.com.unisolutions.PVehiculo[] vehiculos) throws java.rmi.RemoteException;

    /**
     * Recibe un vehículo a asignar a una lista de operaciones y sucursales.
     */
    public int asignarVehiculo(java.lang.String apiKey, java.lang.String vehiculo, ar.com.unisolutions.CodigoSucursalOperacionRequest[] codigosSucursalOperacion, boolean borrarAsignaciones) throws java.rmi.RemoteException;

    /**
     * Recibe una lista de vehículos a asignar a una operacion y sucursal.
     */
    public int asignarVehiculos(java.lang.String apiKey, java.lang.String[] vehiculos, java.lang.String codigoSucursal, java.lang.String codigoOperacion, boolean borrarAsignaciones) throws java.rmi.RemoteException;

    /**
     * Recibe los vehículos activos para una jornada de distribución.
     */
    public int activarVehiculos(java.lang.String apiKey, ar.com.unisolutions.PVehiculo[] vehiculos, java.lang.String codigoSucursal) throws java.rmi.RemoteException;

    /**
     * Obtiene una ruta completa.
     */
    public ar.com.unisolutions.PRuta obtenerRutaCompleta(java.lang.String apiKey, int idJornada, int idRuta) throws java.rmi.RemoteException;

    /**
     * Retorna las órdenes de las rutas solicitadas.
     */
    public ar.com.unisolutions.PRuta[] obtenerRutas(java.lang.String apiKey, java.util.Calendar fecha, java.lang.String codigoSucursal) throws java.rmi.RemoteException;

    /**
     * Retorna las órdenes de las rutas solicitadas.
     */
    public ar.com.unisolutions.PRuta[] obtenerRutasRequest(ar.com.unisolutions.PObtenerRutasRequest request) throws java.rmi.RemoteException;

    /**
     * Retorna las órdenes de las rutas solicitadas incluyendo las
     * que no tienen ruta asignada (Ruta 0).
     */
    public ar.com.unisolutions.PRuta[] obtenerRutas_Ruta0(java.lang.String apiKey, java.util.Calendar fecha, java.lang.String codigoSucursal) throws java.rmi.RemoteException;

    /**
     * Retorna las órdenes de las rutas solicitadas incluyendo las
     * que no tienen ruta asignada (Ruta 0).
     */
    public ar.com.unisolutions.PRuta[] obtenerRutas_Ruta0Request(ar.com.unisolutions.PObtenerRutasRequest request) throws java.rmi.RemoteException;

    /**
     * Retorna las paradas
     */
    public ar.com.unisolutions.PParada[] obtenerParadas(java.lang.String apiKey, java.util.Calendar fecha, long idViaje, java.lang.String estadoViaje, java.lang.String codigoSucursal) throws java.rmi.RemoteException;

    /**
     * Retorna el detalle de una incidencia
     */
    public ar.com.unisolutions.PIncidencia obtenerIncidencia(java.lang.String apiKey, int idIncidencia) throws java.rmi.RemoteException;

    /**
     * Retorna la liquidacion con el detalle de sus guias
     */
    public ar.com.unisolutions.PLiquidacion obtenerLiquidacion(java.lang.String apiKey, int idLiquidacion, java.lang.String referenciaLiquidacion) throws java.rmi.RemoteException;

    /**
     * Retorna las liquidaciones en estados configurados por Action
     */
    public ar.com.unisolutions.PLiquidacion[] obtenerLiquidaciones(java.lang.String apiKey) throws java.rmi.RemoteException;

    String getXmlRequest();
}
