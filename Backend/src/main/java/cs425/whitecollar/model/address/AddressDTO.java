package cs425.whitecollar.model.address;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipcode;


    public AddressDTO(Long id, String street, String city, String state, String zipcode) {
        this.id=id;
        this.street=street;
        this.city=city;
        this.state=state;
        this.zipcode=zipcode;
    }

    public AddressDTO() {

    }
}