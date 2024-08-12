package cs425.whitecollar.model.user;


import cs425.whitecollar.model.address.AddressDTO;

public record UserRegisterationDTO(
         String firstName,
         String lastName,
         String email,
         String password,
         AddressDTO addressDTO
){ }