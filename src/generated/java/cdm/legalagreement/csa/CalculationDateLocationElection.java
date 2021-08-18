package cdm.legalagreement.csa;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.CalculationDateLocationElectionMeta;
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
 * A class to specify each of the party elections with respect to the Calculation Date Location. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (d)(i): Calculation Date Location. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(i): Calculation Date Location. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(i): Calculation Date Location.
 * @version ${project.version}
 */
@RosettaClass

public interface CalculationDateLocationElection extends RosettaModelObject {
	CalculationDateLocationElection build();
	CalculationDateLocationElection.CalculationDateLocationElectionBuilder toBuilder();
	
	/**
	 * The Calculation Date Location when specified as a business center which corresponds to the FpML list of business centers or can be mapped to it.
	 */
	FieldWithMetaBusinessCenterEnum getBusinessCenter();
	/**
	 * The Calculation Date Location when specified a location which doesn&#39;t correspond to the FpML list of business centers or cannot be mapped to it.
	 */
	String getCustomLocation();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	final static CalculationDateLocationElectionMeta metaData = new CalculationDateLocationElectionMeta();
	
	@Override
	default RosettaMetaData<? extends CalculationDateLocationElection> metaData() {
		return metaData;
	} 
			
	static CalculationDateLocationElection.CalculationDateLocationElectionBuilder builder() {
		return new CalculationDateLocationElection.CalculationDateLocationElectionBuilderImpl();
	}
	
	default Class<? extends CalculationDateLocationElection> getType() {
		return CalculationDateLocationElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customLocation"), String.class, getCustomLocation(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
		processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnum.class, getBusinessCenter());
	}
	
	
	interface CalculationDateLocationElectionBuilder extends CalculationDateLocationElection, RosettaModelObjectBuilder {
		FieldWithMetaBusinessCenterEnumBuilder getOrCreateBusinessCenter();
		FieldWithMetaBusinessCenterEnumBuilder getBusinessCenter();
		CalculationDateLocationElection.CalculationDateLocationElectionBuilder setBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter);
		CalculationDateLocationElection.CalculationDateLocationElectionBuilder setBusinessCenterValue(BusinessCenterEnum businessCenter);
		CalculationDateLocationElection.CalculationDateLocationElectionBuilder setCustomLocation(String customLocation);
		CalculationDateLocationElection.CalculationDateLocationElectionBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customLocation"), String.class, getCustomLocation(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
			processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnumBuilder.class, getBusinessCenter());
		}
		
	}
	
	//CalculationDateLocationElection.CalculationDateLocationElectionImpl
	class CalculationDateLocationElectionImpl implements CalculationDateLocationElection {
		private final FieldWithMetaBusinessCenterEnum businessCenter;
		private final String customLocation;
		private final CounterpartyRoleEnum party;
		
		protected CalculationDateLocationElectionImpl(CalculationDateLocationElection.CalculationDateLocationElectionBuilder builder) {
			this.businessCenter = ofNullable(builder.getBusinessCenter()).map(f->f.build()).orElse(null);
			this.customLocation = builder.getCustomLocation();
			this.party = builder.getParty();
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnum getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public String getCustomLocation() {
			return customLocation;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public CalculationDateLocationElection build() {
			return this;
		}
		
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder toBuilder() {
			CalculationDateLocationElection.CalculationDateLocationElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationDateLocationElection.CalculationDateLocationElectionBuilder builder) {
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
			ofNullable(getCustomLocation()).ifPresent(builder::setCustomLocation);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationDateLocationElection _that = getType().cast(o);
		
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(customLocation, _that.getCustomLocation())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customLocation != null ? customLocation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationDateLocationElection {" +
				"businessCenter=" + this.businessCenter + ", " +
				"customLocation=" + this.customLocation + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//CalculationDateLocationElection.CalculationDateLocationElectionBuilderImpl
	class CalculationDateLocationElectionBuilderImpl implements CalculationDateLocationElection.CalculationDateLocationElectionBuilder {
	
		protected FieldWithMetaBusinessCenterEnumBuilder businessCenter;
		protected String customLocation;
		protected CounterpartyRoleEnum party;
	
		public CalculationDateLocationElectionBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaBusinessCenterEnumBuilder getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnumBuilder getOrCreateBusinessCenter() {
			FieldWithMetaBusinessCenterEnumBuilder result;
			if (businessCenter!=null) {
				result = businessCenter;
			}
			else {
				result = businessCenter = FieldWithMetaBusinessCenterEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public String getCustomLocation() {
			return customLocation;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
	
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder setBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter) {
			this.businessCenter = businessCenter==null?null:businessCenter.toBuilder();
			return this;
		}
		
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder setBusinessCenterValue(BusinessCenterEnum businessCenter) {
			this.getOrCreateBusinessCenter().setValue(businessCenter);
			return this;
		}
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder setCustomLocation(String customLocation) {
			this.customLocation = customLocation==null?null:customLocation;
			return this;
		}
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public CalculationDateLocationElection build() {
			return new CalculationDateLocationElection.CalculationDateLocationElectionImpl(this);
		}
		
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder prune() {
			if (businessCenter!=null && !businessCenter.prune().hasData()) businessCenter = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessCenter()!=null) return true;
			if (getCustomLocation()!=null) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationDateLocationElection.CalculationDateLocationElectionBuilder o = (CalculationDateLocationElection.CalculationDateLocationElectionBuilder) other;
			
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::setBusinessCenter);
			
			merger.mergeBasic(getCustomLocation(), o.getCustomLocation(), this::setCustomLocation);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationDateLocationElection _that = getType().cast(o);
		
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(customLocation, _that.getCustomLocation())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customLocation != null ? customLocation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationDateLocationElectionBuilder {" +
				"businessCenter=" + this.businessCenter + ", " +
				"customLocation=" + this.customLocation + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
