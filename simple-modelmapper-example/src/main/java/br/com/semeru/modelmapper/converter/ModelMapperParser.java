package br.com.semeru.modelmapper.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class ModelMapperParser {

    private static final ModelMapper modelMapper = new ModelMapper();
    
    public static <O, D> D parseObjectInputToObjectOutput(O  originalObject, Class<D> destinationObject) {
        return parser(destinationObject, originalObject);
    }

    public static <O, D> List<D> parserListObjectInputToObjectOutput(List<O> originalObjects, Class<D> destinationObject) {
        List<D> destinationObjects = new ArrayList<D>();
        for (Object originalObject : originalObjects) {
            destinationObjects.add(parser(destinationObject, originalObject));
        }
        return destinationObjects;
    }

    private static <D> D parser(Class<D> destinationObject, Object originalObject) {
        return modelMapper.map(originalObject,destinationObject); 
    }
}
