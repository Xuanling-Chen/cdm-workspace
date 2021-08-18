package cdm.observable.asset;

import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.meta.SecurityValuationMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 *  Terms defining the security valuation method as part of a security leg in a securities fianncing transaction and closely modelled onto the CollateralValuation type in FpML.
 * @version ${project.version}
 */
@RosettaClass

public interface SecurityValuation extends RosettaModelObject {
	SecurityValuation build();
	SecurityValuation.SecurityValuationBuilder toBuilder();
	
	/**
	 * The security valuation model choice, based on either a nominal amount or a number of units.
	 */
	SecurityValuationModel getSecurityValuationModel();
	/**
	 * The underlying security of the security leg.
	 */
	Security getUnderlier();
	final static SecurityValuationMeta metaData = new SecurityValuationMeta();
	
	@Override
	default RosettaMetaData<? extends SecurityValuation> metaData() {
		return metaData;
	} 
			
	static SecurityValuation.SecurityValuationBuilder builder() {
		return new SecurityValuation.SecurityValuationBuilderImpl();
	}
	
	default Class<? extends SecurityValuation> getType() {
		return SecurityValuation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("securityValuationModel"), processor, SecurityValuationModel.class, getSecurityValuationModel());
		processRosetta(path.newSubPath("underlier"), processor, Security.class, getUnderlier());
	}
	
	
	interface SecurityValuationBuilder extends SecurityValuation, RosettaModelObjectBuilder {
		SecurityValuationModel.SecurityValuationModelBuilder getOrCreateSecurityValuationModel();
		SecurityValuationModel.SecurityValuationModelBuilder getSecurityValuationModel();
		Security.SecurityBuilder getOrCreateUnderlier();
		Security.SecurityBuilder getUnderlier();
		SecurityValuation.SecurityValuationBuilder setSecurityValuationModel(SecurityValuationModel securityValuationModel);
		SecurityValuation.SecurityValuationBuilder setUnderlier(Security underlier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("securityValuationModel"), processor, SecurityValuationModel.SecurityValuationModelBuilder.class, getSecurityValuationModel());
			processRosetta(path.newSubPath("underlier"), processor, Security.SecurityBuilder.class, getUnderlier());
		}
		
	}
	
	//SecurityValuation.SecurityValuationImpl
	class SecurityValuationImpl implements SecurityValuation {
		private final SecurityValuationModel securityValuationModel;
		private final Security underlier;
		
		protected SecurityValuationImpl(SecurityValuation.SecurityValuationBuilder builder) {
			this.securityValuationModel = ofNullable(builder.getSecurityValuationModel()).map(f->f.build()).orElse(null);
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public SecurityValuationModel getSecurityValuationModel() {
			return securityValuationModel;
		}
		
		@Override
		public Security getUnderlier() {
			return underlier;
		}
		
		@Override
		public SecurityValuation build() {
			return this;
		}
		
		@Override
		public SecurityValuation.SecurityValuationBuilder toBuilder() {
			SecurityValuation.SecurityValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityValuation.SecurityValuationBuilder builder) {
			ofNullable(getSecurityValuationModel()).ifPresent(builder::setSecurityValuationModel);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityValuation _that = getType().cast(o);
		
			if (!Objects.equals(securityValuationModel, _that.getSecurityValuationModel())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (securityValuationModel != null ? securityValuationModel.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityValuation {" +
				"securityValuationModel=" + this.securityValuationModel + ", " +
				"underlier=" + this.underlier +
			'}';
		}
	}
	
	//SecurityValuation.SecurityValuationBuilderImpl
	class SecurityValuationBuilderImpl implements SecurityValuation.SecurityValuationBuilder {
	
		protected SecurityValuationModel.SecurityValuationModelBuilder securityValuationModel;
		protected Security.SecurityBuilder underlier;
	
		public SecurityValuationBuilderImpl() {
		}
	
		@Override
		public SecurityValuationModel.SecurityValuationModelBuilder getSecurityValuationModel() {
			return securityValuationModel;
		}
		
		@Override
		public SecurityValuationModel.SecurityValuationModelBuilder getOrCreateSecurityValuationModel() {
			SecurityValuationModel.SecurityValuationModelBuilder result;
			if (securityValuationModel!=null) {
				result = securityValuationModel;
			}
			else {
				result = securityValuationModel = SecurityValuationModel.builder();
			}
			
			return result;
		}
		
		@Override
		public Security.SecurityBuilder getUnderlier() {
			return underlier;
		}
		
		@Override
		public Security.SecurityBuilder getOrCreateUnderlier() {
			Security.SecurityBuilder result;
			if (underlier!=null) {
				result = underlier;
			}
			else {
				result = underlier = Security.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SecurityValuation.SecurityValuationBuilder setSecurityValuationModel(SecurityValuationModel securityValuationModel) {
			this.securityValuationModel = securityValuationModel==null?null:securityValuationModel.toBuilder();
			return this;
		}
		@Override
		public SecurityValuation.SecurityValuationBuilder setUnderlier(Security underlier) {
			this.underlier = underlier==null?null:underlier.toBuilder();
			return this;
		}
		
		@Override
		public SecurityValuation build() {
			return new SecurityValuation.SecurityValuationImpl(this);
		}
		
		@Override
		public SecurityValuation.SecurityValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityValuation.SecurityValuationBuilder prune() {
			if (securityValuationModel!=null && !securityValuationModel.prune().hasData()) securityValuationModel = null;
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSecurityValuationModel()!=null && getSecurityValuationModel().hasData()) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityValuation.SecurityValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityValuation.SecurityValuationBuilder o = (SecurityValuation.SecurityValuationBuilder) other;
			
			merger.mergeRosetta(getSecurityValuationModel(), o.getSecurityValuationModel(), this::setSecurityValuationModel);
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityValuation _that = getType().cast(o);
		
			if (!Objects.equals(securityValuationModel, _that.getSecurityValuationModel())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (securityValuationModel != null ? securityValuationModel.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityValuationBuilder {" +
				"securityValuationModel=" + this.securityValuationModel + ", " +
				"underlier=" + this.underlier +
			'}';
		}
	}
}
