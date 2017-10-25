package com.github.nosachigor23.shoponline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "input_device")

public class InputDeviceEntity extends AProductEntity implements Serializable {

	@Column(name = "color")
	private String color;

	@Column(name = "discount")
	private int discount;

	public InputDeviceEntity() {

		this.type = "inputDevice";

	}

	public InputDeviceEntity(String color) {
		this.type = "inputDevice";


		this.color = color;

	}

	public String getColor() {
		return color;
	}

	/*

	Since the object is first created, and then the fields in the form of Thymeleaf are filled through the setters,
	the value of the discount will change with each change of the given field (in this case - 'color').

	 */

	public void setColor(String color) {

		this.color = color;

		this.discount = calculateDiscountForProduct();

	}

	public int getDiscount() {
		return this.discount;
	}


	@Override
	public String toString() {
		return ", id=" + id +
				"InputDeviceEntity{" +
				"color='" + color + '\'' +
				", discount=" + discount +
				", amount=" + amount +
				", type='" + type + '\'' +
				", producing_country='" + producing_country + '\'' +
				", price=" + price +
				'}';
	}

	/*

	For input device with pink color price equals '40'%;

	 */

	@Override
	protected int calculateDiscountForProduct() {

		if (!day.matches("TUESDAY|WEDNESDAY")) {
			return 0;
		}

		if (getColor().equalsIgnoreCase("pink")) {

			return 40;

		} else {

			return DEFAULT_DISCOUNT_FOR_ALL_PRODUCTS;

		}

	}

}