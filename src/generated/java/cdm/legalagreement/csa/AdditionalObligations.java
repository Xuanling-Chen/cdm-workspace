package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.AdditionalObligationsMeta;
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
 * The election of party specific additional obligations applicable to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface AdditionalObligations extends RosettaModelObject {
	AdditionalObligations build();
	AdditionalObligations.AdditionalObligationsBuilder toBuilder();
	
	/**
	 * The party specific additional obligations applicable to the agreement.
	 */
	String getAdditionalObligations();
	/**
	 * The party that the additional obligations apply to.
	 */
	CounterpartyRoleEnum getParty();
	final static AdditionalObligationsMeta metaData = new AdditionalObligationsMeta();
	
	@Override
	default RosettaMetaData<? extends AdditionalObligations> metaData() {
		return metaData;
	} 
			
	static AdditionalObligations.AdditionalObligationsBuilder builder() {
		return new AdditionalObligations.AdditionalObligationsBuilderImpl();
	}
	
	default Class<? extends AdditionalObligations> getType() {
		return AdditionalObligations.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalObligations"), String.class, getAdditionalObligations(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
	}
	
	
	interface AdditionalObligationsBuilder extends AdditionalObligations, RosettaModelObjectBuilder {
		AdditionalObligations.AdditionalObligationsBuilder setAdditionalObligations(String additionalObligations);
		AdditionalObligations.AdditionalObligationsBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalObligations"), String.class, getAdditionalObligations(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
		}
		
	}
	
	//AdditionalObligations.AdditionalObligationsImpl
	class AdditionalObligationsImpl implements AdditionalObligations {
		private final String additionalObligations;
		private final CounterpartyRoleEnum party;
		
		protected AdditionalObligationsImpl(AdditionalObligations.AdditionalObligationsBuilder builder) {
			this.additionalObligations = builder.getAdditionalObligations();
			this.party = builder.getParty();
		}
		
		@Override
		public String getAdditionalObligations() {
			return additionalObligations;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public AdditionalObligations build() {
			return this;
		}
		
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder toBuilder() {
			AdditionalObligations.AdditionalObligationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalObligations.AdditionalObligationsBuilder builder) {
			ofNullable(getAdditionalObligations()).ifPresent(builder::setAdditionalObligations);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalObligations _that = getType().cast(o);
		
			if (!Objects.equals(additionalObligations, _that.getAdditionalObligations())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalObligations {" +
				"additionalObligations=" + this.additionalObligations + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//AdditionalObligations.AdditionalObligationsBuilderImpl
	class AdditionalObligationsBuilderImpl implements AdditionalObligations.AdditionalObligationsBuilder {
	
		protected String additionalObligations;
		protected CounterpartyRoleEnum party;
	
		public AdditionalObligationsBuilderImpl() {
		}
	
		@Override
		public String getAdditionalObligations() {
			return additionalObligations;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
	
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder setAdditionalObligations(String additionalObligations) {
			this.additionalObligations = additionalObligations==null?null:additionalObligations;
			return this;
		}
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public AdditionalObligations build() {
			return new AdditionalObligations.AdditionalObligationsImpl(this);
		}
		
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalObligations()!=null) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalObligations.AdditionalObligationsBuilder o = (AdditionalObligations.AdditionalObligationsBuilder) other;
			
			
			merger.mergeBasic(getAdditionalObligations(), o.getAdditionalObligations(), this::setAdditionalObligations);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalObligations _that = getType().cast(o);
		
			if (!Objects.equals(additionalObligations, _that.getAdditionalObligations())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalObligationsBuilder {" +
				"additionalObligations=" + this.additionalObligations + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
