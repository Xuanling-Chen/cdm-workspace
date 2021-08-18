package cdm.observable.asset;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.asset.meta.CalculationAgentMeta;
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
 * A class defining the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
 * @version ${project.version}
 */
@RosettaClass

public interface CalculationAgent extends RosettaModelObject {
	CalculationAgent build();
	CalculationAgent.CalculationAgentBuilder toBuilder();
	
	/**
	 * The city in which the office through which ISDA Calculation Agent is acting for purposes of the transaction is located The short-form confirm for a trade that is executed under a Sovereign or Asia Pacific Master Confirmation Agreement ( MCA ), does not need to specify the Calculation Agent. However, the confirm does need to specify the Calculation Agent City. This is due to the fact that the MCA sets the value for Calculation Agent but does not set the value for Calculation Agent City.
	 */
	FieldWithMetaBusinessCenterEnum getCalculationAgentBusinessCenter();
	/**
	 * Specifies the party which is the ISDA Calculation Agent for the trade. If more than one party is referenced then the parties are assumed to be co-calculation agents, i.e. they have joint responsibility.
	 */
	AncillaryRoleEnum getCalculationAgentParty();
	/**
	 * Specifies the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions. For example, the Calculation Agent may be defined as being the Non-exercising Party.
	 */
	PartyDeterminationEnum getCalculationAgentPartyEnum();
	final static CalculationAgentMeta metaData = new CalculationAgentMeta();
	
	@Override
	default RosettaMetaData<? extends CalculationAgent> metaData() {
		return metaData;
	} 
			
	static CalculationAgent.CalculationAgentBuilder builder() {
		return new CalculationAgent.CalculationAgentBuilderImpl();
	}
	
	default Class<? extends CalculationAgent> getType() {
		return CalculationAgent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("calculationAgentParty"), AncillaryRoleEnum.class, getCalculationAgentParty(), this);
		processor.processBasic(path.newSubPath("calculationAgentPartyEnum"), PartyDeterminationEnum.class, getCalculationAgentPartyEnum(), this);
		
		processRosetta(path.newSubPath("calculationAgentBusinessCenter"), processor, FieldWithMetaBusinessCenterEnum.class, getCalculationAgentBusinessCenter());
	}
	
	
	interface CalculationAgentBuilder extends CalculationAgent, RosettaModelObjectBuilder {
		FieldWithMetaBusinessCenterEnumBuilder getOrCreateCalculationAgentBusinessCenter();
		FieldWithMetaBusinessCenterEnumBuilder getCalculationAgentBusinessCenter();
		CalculationAgent.CalculationAgentBuilder setCalculationAgentBusinessCenter(FieldWithMetaBusinessCenterEnum calculationAgentBusinessCenter);
		CalculationAgent.CalculationAgentBuilder setCalculationAgentBusinessCenterValue(BusinessCenterEnum calculationAgentBusinessCenter);
		CalculationAgent.CalculationAgentBuilder setCalculationAgentParty(AncillaryRoleEnum calculationAgentParty);
		CalculationAgent.CalculationAgentBuilder setCalculationAgentPartyEnum(PartyDeterminationEnum calculationAgentPartyEnum);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("calculationAgentParty"), AncillaryRoleEnum.class, getCalculationAgentParty(), this);
			processor.processBasic(path.newSubPath("calculationAgentPartyEnum"), PartyDeterminationEnum.class, getCalculationAgentPartyEnum(), this);
			
			processRosetta(path.newSubPath("calculationAgentBusinessCenter"), processor, FieldWithMetaBusinessCenterEnumBuilder.class, getCalculationAgentBusinessCenter());
		}
		
	}
	
	//CalculationAgent.CalculationAgentImpl
	class CalculationAgentImpl implements CalculationAgent {
		private final FieldWithMetaBusinessCenterEnum calculationAgentBusinessCenter;
		private final AncillaryRoleEnum calculationAgentParty;
		private final PartyDeterminationEnum calculationAgentPartyEnum;
		
		protected CalculationAgentImpl(CalculationAgent.CalculationAgentBuilder builder) {
			this.calculationAgentBusinessCenter = ofNullable(builder.getCalculationAgentBusinessCenter()).map(f->f.build()).orElse(null);
			this.calculationAgentParty = builder.getCalculationAgentParty();
			this.calculationAgentPartyEnum = builder.getCalculationAgentPartyEnum();
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnum getCalculationAgentBusinessCenter() {
			return calculationAgentBusinessCenter;
		}
		
		@Override
		public AncillaryRoleEnum getCalculationAgentParty() {
			return calculationAgentParty;
		}
		
		@Override
		public PartyDeterminationEnum getCalculationAgentPartyEnum() {
			return calculationAgentPartyEnum;
		}
		
		@Override
		public CalculationAgent build() {
			return this;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder toBuilder() {
			CalculationAgent.CalculationAgentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationAgent.CalculationAgentBuilder builder) {
			ofNullable(getCalculationAgentBusinessCenter()).ifPresent(builder::setCalculationAgentBusinessCenter);
			ofNullable(getCalculationAgentParty()).ifPresent(builder::setCalculationAgentParty);
			ofNullable(getCalculationAgentPartyEnum()).ifPresent(builder::setCalculationAgentPartyEnum);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAgent _that = getType().cast(o);
		
			if (!Objects.equals(calculationAgentBusinessCenter, _that.getCalculationAgentBusinessCenter())) return false;
			if (!Objects.equals(calculationAgentParty, _that.getCalculationAgentParty())) return false;
			if (!Objects.equals(calculationAgentPartyEnum, _that.getCalculationAgentPartyEnum())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAgentBusinessCenter != null ? calculationAgentBusinessCenter.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationAgentParty != null ? calculationAgentParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationAgentPartyEnum != null ? calculationAgentPartyEnum.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAgent {" +
				"calculationAgentBusinessCenter=" + this.calculationAgentBusinessCenter + ", " +
				"calculationAgentParty=" + this.calculationAgentParty + ", " +
				"calculationAgentPartyEnum=" + this.calculationAgentPartyEnum +
			'}';
		}
	}
	
	//CalculationAgent.CalculationAgentBuilderImpl
	class CalculationAgentBuilderImpl implements CalculationAgent.CalculationAgentBuilder {
	
		protected FieldWithMetaBusinessCenterEnumBuilder calculationAgentBusinessCenter;
		protected AncillaryRoleEnum calculationAgentParty;
		protected PartyDeterminationEnum calculationAgentPartyEnum;
	
		public CalculationAgentBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaBusinessCenterEnumBuilder getCalculationAgentBusinessCenter() {
			return calculationAgentBusinessCenter;
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnumBuilder getOrCreateCalculationAgentBusinessCenter() {
			FieldWithMetaBusinessCenterEnumBuilder result;
			if (calculationAgentBusinessCenter!=null) {
				result = calculationAgentBusinessCenter;
			}
			else {
				result = calculationAgentBusinessCenter = FieldWithMetaBusinessCenterEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public AncillaryRoleEnum getCalculationAgentParty() {
			return calculationAgentParty;
		}
		
		@Override
		public PartyDeterminationEnum getCalculationAgentPartyEnum() {
			return calculationAgentPartyEnum;
		}
		
	
		@Override
		public CalculationAgent.CalculationAgentBuilder setCalculationAgentBusinessCenter(FieldWithMetaBusinessCenterEnum calculationAgentBusinessCenter) {
			this.calculationAgentBusinessCenter = calculationAgentBusinessCenter==null?null:calculationAgentBusinessCenter.toBuilder();
			return this;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder setCalculationAgentBusinessCenterValue(BusinessCenterEnum calculationAgentBusinessCenter) {
			this.getOrCreateCalculationAgentBusinessCenter().setValue(calculationAgentBusinessCenter);
			return this;
		}
		@Override
		public CalculationAgent.CalculationAgentBuilder setCalculationAgentParty(AncillaryRoleEnum calculationAgentParty) {
			this.calculationAgentParty = calculationAgentParty==null?null:calculationAgentParty;
			return this;
		}
		@Override
		public CalculationAgent.CalculationAgentBuilder setCalculationAgentPartyEnum(PartyDeterminationEnum calculationAgentPartyEnum) {
			this.calculationAgentPartyEnum = calculationAgentPartyEnum==null?null:calculationAgentPartyEnum;
			return this;
		}
		
		@Override
		public CalculationAgent build() {
			return new CalculationAgent.CalculationAgentImpl(this);
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAgent.CalculationAgentBuilder prune() {
			if (calculationAgentBusinessCenter!=null && !calculationAgentBusinessCenter.prune().hasData()) calculationAgentBusinessCenter = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationAgentBusinessCenter()!=null) return true;
			if (getCalculationAgentParty()!=null) return true;
			if (getCalculationAgentPartyEnum()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAgent.CalculationAgentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationAgent.CalculationAgentBuilder o = (CalculationAgent.CalculationAgentBuilder) other;
			
			merger.mergeRosetta(getCalculationAgentBusinessCenter(), o.getCalculationAgentBusinessCenter(), this::setCalculationAgentBusinessCenter);
			
			merger.mergeBasic(getCalculationAgentParty(), o.getCalculationAgentParty(), this::setCalculationAgentParty);
			merger.mergeBasic(getCalculationAgentPartyEnum(), o.getCalculationAgentPartyEnum(), this::setCalculationAgentPartyEnum);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAgent _that = getType().cast(o);
		
			if (!Objects.equals(calculationAgentBusinessCenter, _that.getCalculationAgentBusinessCenter())) return false;
			if (!Objects.equals(calculationAgentParty, _that.getCalculationAgentParty())) return false;
			if (!Objects.equals(calculationAgentPartyEnum, _that.getCalculationAgentPartyEnum())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAgentBusinessCenter != null ? calculationAgentBusinessCenter.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationAgentParty != null ? calculationAgentParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationAgentPartyEnum != null ? calculationAgentPartyEnum.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAgentBuilder {" +
				"calculationAgentBusinessCenter=" + this.calculationAgentBusinessCenter + ", " +
				"calculationAgentParty=" + this.calculationAgentParty + ", " +
				"calculationAgentPartyEnum=" + this.calculationAgentPartyEnum +
			'}';
		}
	}
}
