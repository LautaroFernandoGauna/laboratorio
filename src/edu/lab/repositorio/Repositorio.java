package edu.lab.repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Repositorio<T> {
    private List<T> lista= new ArrayList<>();

    public void agregar(T elemento){
         if (elemento== null)  {
            throw new IllegalArgumentException("No se puede agregar un elemento nulo");
        }
        lista.add(elemento);
    }
    public boolean quitar(T elemento){
        if (elemento== null)  {
            throw new IllegalArgumentException("No se puede eliminar un elemento nulo");
        }
        return this.lista.remove(elemento);
    }
    public List<T> verTodo(){
        return Collections.unmodifiableList(lista);
    }

    public List<T> filtrarPorCriterio(List<T> lista, Predicate<T> criterio){
        List<T> result = new ArrayList<>();
        for(T e : lista){
            if(criterio.test(e)){
                result.add(e);
            }

        }
        return result;
    }
     public Stream<T> stream() {
        return lista.stream();
    }    
}
