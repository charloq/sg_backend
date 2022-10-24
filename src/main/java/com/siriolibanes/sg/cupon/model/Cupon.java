package com.siriolibanes.sg.cupon.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.siriolibanes.sg.base.model.Entidad;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Cupon extends Entidad {

}
