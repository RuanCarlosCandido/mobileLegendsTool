package org.models;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Behaviour {
	//thhis iddentation must be removed after the tests are OK
	ARMOR_BREAKER			(Arrays.asList("SHIELD","HP_POOL")),	
	CROWD_CONTROL		  	(Arrays.asList("CONTROL_IMMUNITY", "SKILL_SUPPRESSION")),
	CONTROL_IMMUNITY		(Arrays.asList("EXPLOSION","LONG_RANGE","HIGH_MOBILITY")),
	ENDURANCE				(Arrays.asList("ARMOR_BREAKER","REAL_DAMAGE")),
	ENCAGE					(Arrays.asList("CONTROL_IMMUNITY","CROWD_CONTROL")),
	EXPLOSION				(Arrays.asList("ENDURANCE", "HP_POOL", "SHIELD")),
	HP_BASED_DAMAGE		    (Arrays.asList("REGENERATION")),
	HP_POOL		            (Arrays.asList("HP_BASED_DAMAGE")),
	HIGH_MOBILITY			(Arrays.asList("SKILL_SUPPRESSION","ENCAGE","EXPLOSION","INVULNERABILITY")),
	INVULNERABILITY			(Arrays.asList("SKILL_SUPPRESSION","ENCAGE")),
	INVISIBILITY		    (Arrays.asList("ENCAGE", "SPLASH_DAMAGE")),
	KNOCK_BACK   			(Arrays.asList("SKILL_SUPPRESSION","CONTROL_IMMUNITY")),
	LONG_RANGE				(Arrays.asList("SUMMON","INVULNERABILITY","EXPLOSION","ENDURANCE")),
	MAGIC_DAMAGE			(Arrays.asList("MAGIC_DEFENSE")),
	MAGIC_DEFENSE			(Arrays.asList("ARMOR_BREAKER","REAL_DAMAGE")),
	MANA_POOL				(Arrays.asList("")),
	MANA_REGENERATION		(Arrays.asList("")),
	PHYSICAL_DEFENSE		(Arrays.asList("ARMOR_BREAKER","REAL_DAMAGE")),
	REFLECTION				(Arrays.asList("SUMMON","LONG_RANGE")),
	REAL_DAMAGE				(Arrays.asList("HIGH_MOBILITY","REGENERATION")),
	REGENERATION		  	(Arrays.asList("REGENERATION_REDUCTION", "SUMMON", "LONG_RANGE")),
	REGENERATION_REDUCTION	(Arrays.asList("LONG_RANGE")),
	RESSURECTION		  	(Arrays.asList("HIGH_MOBILITY","LONG_RANGE")),
	REAP					(Arrays.asList("REFLECTION","INVULNERABILITY","SHIELD")),
	SPLASH_DAMAGE			(Arrays.asList("ENDURANCE","SHIELD","HIGH_MOBILITY","SKILL_SUPPRESSION")),
	SUMMON					(Arrays.asList("INVULNERABILITY","SPLASH_DAMAGE","SHIELD")),
	SHIELD					(Arrays.asList("SHIELD_STEALING", "REAL_DAMAGE", "REGENERATION")),
	SHIELD_STEALING			(Arrays.asList("REGENERATION_REDUCTION","REAL_DAMAGE")),
	SKILL_SUPPRESSION		(Arrays.asList("SUMMON","CONTROL_IMMUNITY"));



	static Map<String, Behaviour> namesMap = new HashMap<String, Behaviour>();

	static { Arrays.asList(values()).forEach(behaviour -> namesMap.put(behaviour.toString(), behaviour)); }



	List<String> weaknesses = new ArrayList<String>();
	Behaviour(List<String> weaknesses) {
		this.weaknesses = weaknesses;
	}


	public List<Behaviour> getWeaknesses() {

		List<Behaviour> result = new ArrayList<Behaviour>();
		for (String weaknessAsString : weaknesses) {
			result.add(namesMap.get(weaknessAsString));
		}

		return result;
	}



}