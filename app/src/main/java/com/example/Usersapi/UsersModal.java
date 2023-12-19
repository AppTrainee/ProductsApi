// UsersModal.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.Usersapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersModal {
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("company")
    @Expose
    private Company company;
    @SerializedName("id")
    @Expose
    private String  id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;


    public String getWebsite() { return website; }
    public void setWebsite(String value) { this.website = value; }

    public Address getAddress() { return address; }
    public void setAddress(Address value) { this.address = value; }

    public String getPhone() { return phone; }
    public void setPhone(String value) { this.phone = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Company getCompany() { return company; }
    public void setCompany(Company value) { this.company = value; }

    public String getid() { return id; }
    public void setid(String value) { this.id = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getUsername() { return username; }
    public void setUsername(String value) { this.username = value; }
}

// Address.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Address {
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("geo")
    @Expose
    private Geo geo;
    @SerializedName("suite")
    @Expose
    private String suite;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("street")
    @Expose
    private String street;


    public String getZipcode() { return zipcode; }
    public void setZipcode(String value) { this.zipcode = value; }

    public Geo getGeo() { return geo; }
    public void setGeo(Geo value) { this.geo = value; }

    public String getSuite() { return suite; }
    public void setSuite(String value) { this.suite = value; }

    public String getCity() { return city; }
    public void setCity(String value) { this.city = value; }

    public String getStreet() { return street; }
    public void setStreet(String value) { this.street = value; }
}

// Geo.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Geo {
    @SerializedName("street")
    @Expose
    private String lng;
    @SerializedName("street")
    @Expose
    private String lat;

    public String getLng() { return lng; }
    public void setLng(String value) { this.lng = value; }

    public String getLat() { return lat; }
    public void setLat(String value) { this.lat = value; }
}

// Company.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Company {
    private String bs;
    private String catchPhrase;
    private String name;

    public String getBs() { return bs; }
    public void setBs(String value) { this.bs = value; }

    public String getCatchPhrase() { return catchPhrase; }
    public void setCatchPhrase(String value) { this.catchPhrase = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
}
