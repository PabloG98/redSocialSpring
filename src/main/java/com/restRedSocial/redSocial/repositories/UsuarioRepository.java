package com.restRedSocial.redSocial.repositories;

import com.restRedSocial.redSocial.models.Usuarios;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository <Usuarios, String >{
	Usuarios findBy_id(ObjectId _id);
}
