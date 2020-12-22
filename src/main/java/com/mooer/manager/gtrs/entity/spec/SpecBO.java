package com.mooer.manager.gtrs.entity.spec;

import java.util.List;

import com.mooer.manager.gtrs.pojo.Spec;
import com.mooer.manager.gtrs.pojo.SpecOption;

public class SpecBO {
	
	Spec spec;

	List<SpecOption> specOptions;

	public Spec getSpec() {
		return spec;
	}

	public void setSpec(Spec spec) {
		this.spec = spec;
	}

	public List<SpecOption> getSpecOptions() {
		return specOptions;
	}

	public void setSpecOptions(List<SpecOption> specOptions) {
		this.specOptions = specOptions;
	}

}
