package com.greg.middleware.clients;


/*
* Classe de filtro do endpoint
*
* @author Greg
* @version 1.0
* @since 2023-11-30
* */
public class PokemonRequest {
    private String name;
    private String speciesName;
    private Integer typeId;
    private String abilityName;
    private Integer limit;
    private Integer offset;

    public PokemonRequest(String name, String speciesName, Integer typeId, String abilityName, Integer limit, Integer offset) {
        this.name = name;
        this.speciesName = speciesName;
        this.typeId = typeId;
        this.abilityName = abilityName;
        this.limit = limit;
        this.offset = offset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
