package cs425.whitecollar.model.address;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AddressDTOMapper implements Function<Address, AddressDTO> {
    @Override
    public AddressDTO apply(Address address) {
        return new AddressDTO(address.getId(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipcode());
    }

    @Override
    public <V> Function<V, AddressDTO> compose(Function<? super V, ? extends Address> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Address, V> andThen(Function<? super AddressDTO, ? extends V> after) {
        return Function.super.andThen(after);
    }
}