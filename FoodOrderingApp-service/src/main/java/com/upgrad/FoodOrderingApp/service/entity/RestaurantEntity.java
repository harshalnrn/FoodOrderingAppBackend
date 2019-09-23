package com.upgrad.FoodOrderingApp.service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/** Restaurent entity class */
@Entity
@Table(name = "restaurant")
@NamedQuery(
    name = "getRestaurentById",
    query = "select r from RestaurantEntity r where r.uuid=:uuid")
public class RestaurantEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotNull
  private Integer Id;

  @Column(name = "uuid")
  @NotNull
  @Size(max = 200)
  private String uuid;

  @Column(name = "restaurant_name")
  @Size(max = 50)
  @NotNull
  private String restaurantName;

  @Column(name = "photo_url")
  @Size(max = 255)
  private String photoUrl;

  @Column(name = "customer_rating")
  @NotNull
  private Double customerRating;

  @Column(name = "average_price_for_two")
  @NotNull
  private Integer avgPrice;

  @Column(name = "number_of_customers_rated")
  @NotNull
  private Integer numberCustomersRated;

  @OneToOne(cascade = CascadeType.REMOVE)
  @NotNull
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private AddressEntity address;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

  public Double getCustomerRating() {
    return customerRating;
  }

  public void setCustomerRating(Double customerRating) {
    this.customerRating = customerRating;
  }

  public Integer getAvgPrice() {
    return avgPrice;
  }

  public void setAvgPrice(Integer avgPrice) {
    this.avgPrice = avgPrice;
  }

  public Integer getNumberCustomersRated() {
    return numberCustomersRated;
  }

  public void setNumberCustomersRated(Integer numberCustomersRated) {
    this.numberCustomersRated = numberCustomersRated;
  }

  public AddressEntity getAddress() {
    return address;
  }

  public void setAddress(AddressEntity address) {
    this.address = address;
  }
    }
