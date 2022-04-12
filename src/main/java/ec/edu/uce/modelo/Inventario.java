package ec.edu.uce.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inventario")
	@SequenceGenerator(name = "seq_inventario", sequenceName = "seq_inventario", allocationSize = 1)
	@Column(name = "inve_id")
	private Integer id;

	@Column(name = "inve_numero_bodega")
	private String numeroBodega;

	@Column(name = "inve_codigo_barras_universal")
	private String codigoBarrasUniversal;

	@Column(name = "inve_codigo_barras_individual")
	private String codigoBarrasIndividual;

	@Column(name = "inve_cantidad")
	private Integer cantidad;

	@Column(name = "inve_nombre_hilo")
	private String nombreHilo;

	@ManyToOne()
	@JoinColumn(name = "bode_id")
	private Bodega bodega;

	@OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
	private List<Producto> productos;

}
