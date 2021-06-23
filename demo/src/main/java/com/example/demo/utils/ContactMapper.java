package com.example.demo.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ContactDto;
import com.example.demo.model.Contact;

@Component
public class ContactMapper {

	@Bean
	public ModelMapper modelmapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true);
		modelMapper.getConfiguration().setFieldAccessLevel(AccessLevel.PROTECTED);
		modelMapper.getConfiguration().setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
		TypeMap<Contact, ContactDto> typeMapContact = modelMapper.getTypeMap(Contact.class, ContactDto.class);
		if (typeMapContact == null) {

			modelMapper.addMappings(new PropertyMap<Contact, ContactDto>() {
				@Override
				protected void configure() {
					map(source.getId(), destination.getId());
					map(source.getEmail(),destination.getEmail());
					map(source.getMobile(),destination.getMobile());
					map(source.getName(),destination.getName());
				}
			});

		}
		return modelMapper;
	}
}
