package cdm.product.template;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.RelativeDateOffset;
import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilder;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilderImpl;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerImpl;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.template.meta.EvergreenProvisionMeta;
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
 * Specifies a transaction which automatically extends for a specified timeframe until the exercise of an embedded option.
 * @version ${project.version}
 */
@RosettaClass

public interface EvergreenProvision extends BuyerSeller {
	EvergreenProvision build();
	EvergreenProvision.EvergreenProvisionBuilder toBuilder();
	
	/**
	 * Defines the exercise period for an American style option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees.
	 */
	AmericanExercise getAmericanExercise();
	/**
	 * Defines the Bermuda option exercise dates and the expiration date together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fee.
	 */
	BermudaExercise getBermudaExercise();
	/**
	 * Identifies a party to that has a right to demand for termination of the Security Finance transaction.
	 */
	CallingPartyEnum getCallingParty();
	/**
	 * Defines the exercise period for a European style option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees.
	 */
	EuropeanExercise getEuropeanExercise();
	/**
	 * The length of each Evergreen extension period relative to the Effective date of the preceding contract.
	 */
	RelativeDateOffset getEvergreenExtensionPeriod();
	/**
	 * The frequency with which the Evergreen contract will be extended if notice is not given.
	 */
	CalculationPeriodFrequency getEvergreenRollFrequency();
	/**
	 * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller&#39;s agent.
	 */
	Boolean getFollowUpConfirmation();
	final static EvergreenProvisionMeta metaData = new EvergreenProvisionMeta();
	
	@Override
	default RosettaMetaData<? extends EvergreenProvision> metaData() {
		return metaData;
	} 
			
	static EvergreenProvision.EvergreenProvisionBuilder builder() {
		return new EvergreenProvision.EvergreenProvisionBuilderImpl();
	}
	
	default Class<? extends EvergreenProvision> getType() {
		return EvergreenProvision.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.party.BuyerSeller.super.process(path, processor);
		processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		
		processRosetta(path.newSubPath("americanExercise"), processor, AmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("bermudaExercise"), processor, BermudaExercise.class, getBermudaExercise());
		processRosetta(path.newSubPath("europeanExercise"), processor, EuropeanExercise.class, getEuropeanExercise());
		processRosetta(path.newSubPath("evergreenExtensionPeriod"), processor, RelativeDateOffset.class, getEvergreenExtensionPeriod());
		processRosetta(path.newSubPath("evergreenRollFrequency"), processor, CalculationPeriodFrequency.class, getEvergreenRollFrequency());
	}
	
	
	interface EvergreenProvisionBuilder extends EvergreenProvision, BuyerSeller.BuyerSellerBuilder, RosettaModelObjectBuilder {
		AmericanExercise.AmericanExerciseBuilder getOrCreateAmericanExercise();
		AmericanExercise.AmericanExerciseBuilder getAmericanExercise();
		BermudaExercise.BermudaExerciseBuilder getOrCreateBermudaExercise();
		BermudaExercise.BermudaExerciseBuilder getBermudaExercise();
		EuropeanExercise.EuropeanExerciseBuilder getOrCreateEuropeanExercise();
		EuropeanExercise.EuropeanExerciseBuilder getEuropeanExercise();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateEvergreenExtensionPeriod();
		RelativeDateOffset.RelativeDateOffsetBuilder getEvergreenExtensionPeriod();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateEvergreenRollFrequency();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getEvergreenRollFrequency();
		EvergreenProvision.EvergreenProvisionBuilder setAmericanExercise(AmericanExercise americanExercise);
		EvergreenProvision.EvergreenProvisionBuilder setBermudaExercise(BermudaExercise bermudaExercise);
		EvergreenProvision.EvergreenProvisionBuilder setCallingParty(CallingPartyEnum callingParty);
		EvergreenProvision.EvergreenProvisionBuilder setEuropeanExercise(EuropeanExercise europeanExercise);
		EvergreenProvision.EvergreenProvisionBuilder setEvergreenExtensionPeriod(RelativeDateOffset evergreenExtensionPeriod);
		EvergreenProvision.EvergreenProvisionBuilder setEvergreenRollFrequency(CalculationPeriodFrequency evergreenRollFrequency);
		EvergreenProvision.EvergreenProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		EvergreenProvision.EvergreenProvisionBuilder setBuyer(CounterpartyRoleEnum buyer);
		EvergreenProvision.EvergreenProvisionBuilder setSeller(CounterpartyRoleEnum seller);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			BuyerSeller.BuyerSellerBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			
			processRosetta(path.newSubPath("americanExercise"), processor, AmericanExercise.AmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("bermudaExercise"), processor, BermudaExercise.BermudaExerciseBuilder.class, getBermudaExercise());
			processRosetta(path.newSubPath("europeanExercise"), processor, EuropeanExercise.EuropeanExerciseBuilder.class, getEuropeanExercise());
			processRosetta(path.newSubPath("evergreenExtensionPeriod"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getEvergreenExtensionPeriod());
			processRosetta(path.newSubPath("evergreenRollFrequency"), processor, CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder.class, getEvergreenRollFrequency());
		}
		
	}
	
	//EvergreenProvision.EvergreenProvisionImpl
	class EvergreenProvisionImpl extends BuyerSeller.BuyerSellerImpl implements EvergreenProvision {
		private final AmericanExercise americanExercise;
		private final BermudaExercise bermudaExercise;
		private final CallingPartyEnum callingParty;
		private final EuropeanExercise europeanExercise;
		private final RelativeDateOffset evergreenExtensionPeriod;
		private final CalculationPeriodFrequency evergreenRollFrequency;
		private final Boolean followUpConfirmation;
		
		protected EvergreenProvisionImpl(EvergreenProvision.EvergreenProvisionBuilder builder) {
			super(builder);
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.bermudaExercise = ofNullable(builder.getBermudaExercise()).map(f->f.build()).orElse(null);
			this.callingParty = builder.getCallingParty();
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.evergreenExtensionPeriod = ofNullable(builder.getEvergreenExtensionPeriod()).map(f->f.build()).orElse(null);
			this.evergreenRollFrequency = ofNullable(builder.getEvergreenRollFrequency()).map(f->f.build()).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
		}
		
		@Override
		public AmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public BermudaExercise getBermudaExercise() {
			return bermudaExercise;
		}
		
		@Override
		public CallingPartyEnum getCallingParty() {
			return callingParty;
		}
		
		@Override
		public EuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public RelativeDateOffset getEvergreenExtensionPeriod() {
			return evergreenExtensionPeriod;
		}
		
		@Override
		public CalculationPeriodFrequency getEvergreenRollFrequency() {
			return evergreenRollFrequency;
		}
		
		@Override
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		public EvergreenProvision build() {
			return this;
		}
		
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder toBuilder() {
			EvergreenProvision.EvergreenProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EvergreenProvision.EvergreenProvisionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getBermudaExercise()).ifPresent(builder::setBermudaExercise);
			ofNullable(getCallingParty()).ifPresent(builder::setCallingParty);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getEvergreenExtensionPeriod()).ifPresent(builder::setEvergreenExtensionPeriod);
			ofNullable(getEvergreenRollFrequency()).ifPresent(builder::setEvergreenRollFrequency);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EvergreenProvision _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(bermudaExercise, _that.getBermudaExercise())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(evergreenExtensionPeriod, _that.getEvergreenExtensionPeriod())) return false;
			if (!Objects.equals(evergreenRollFrequency, _that.getEvergreenRollFrequency())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (bermudaExercise != null ? bermudaExercise.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (evergreenExtensionPeriod != null ? evergreenExtensionPeriod.hashCode() : 0);
			_result = 31 * _result + (evergreenRollFrequency != null ? evergreenRollFrequency.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EvergreenProvision {" +
				"americanExercise=" + this.americanExercise + ", " +
				"bermudaExercise=" + this.bermudaExercise + ", " +
				"callingParty=" + this.callingParty + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"evergreenExtensionPeriod=" + this.evergreenExtensionPeriod + ", " +
				"evergreenRollFrequency=" + this.evergreenRollFrequency + ", " +
				"followUpConfirmation=" + this.followUpConfirmation +
			'}' + " " + super.toString();
		}
	}
	
	//EvergreenProvision.EvergreenProvisionBuilderImpl
	class EvergreenProvisionBuilderImpl extends BuyerSeller.BuyerSellerBuilderImpl  implements EvergreenProvision.EvergreenProvisionBuilder {
	
		protected AmericanExercise.AmericanExerciseBuilder americanExercise;
		protected BermudaExercise.BermudaExerciseBuilder bermudaExercise;
		protected CallingPartyEnum callingParty;
		protected EuropeanExercise.EuropeanExerciseBuilder europeanExercise;
		protected RelativeDateOffset.RelativeDateOffsetBuilder evergreenExtensionPeriod;
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder evergreenRollFrequency;
		protected Boolean followUpConfirmation;
	
		public EvergreenProvisionBuilderImpl() {
		}
	
		@Override
		public AmericanExercise.AmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public AmericanExercise.AmericanExerciseBuilder getOrCreateAmericanExercise() {
			AmericanExercise.AmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = AmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public BermudaExercise.BermudaExerciseBuilder getBermudaExercise() {
			return bermudaExercise;
		}
		
		@Override
		public BermudaExercise.BermudaExerciseBuilder getOrCreateBermudaExercise() {
			BermudaExercise.BermudaExerciseBuilder result;
			if (bermudaExercise!=null) {
				result = bermudaExercise;
			}
			else {
				result = bermudaExercise = BermudaExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public CallingPartyEnum getCallingParty() {
			return callingParty;
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			EuropeanExercise.EuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = EuropeanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getEvergreenExtensionPeriod() {
			return evergreenExtensionPeriod;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateEvergreenExtensionPeriod() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (evergreenExtensionPeriod!=null) {
				result = evergreenExtensionPeriod;
			}
			else {
				result = evergreenExtensionPeriod = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getEvergreenRollFrequency() {
			return evergreenRollFrequency;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateEvergreenRollFrequency() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder result;
			if (evergreenRollFrequency!=null) {
				result = evergreenRollFrequency;
			}
			else {
				result = evergreenRollFrequency = CalculationPeriodFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
	
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder setAmericanExercise(AmericanExercise americanExercise) {
			this.americanExercise = americanExercise==null?null:americanExercise.toBuilder();
			return this;
		}
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder setBermudaExercise(BermudaExercise bermudaExercise) {
			this.bermudaExercise = bermudaExercise==null?null:bermudaExercise.toBuilder();
			return this;
		}
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder setCallingParty(CallingPartyEnum callingParty) {
			this.callingParty = callingParty==null?null:callingParty;
			return this;
		}
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder setEuropeanExercise(EuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder setEvergreenExtensionPeriod(RelativeDateOffset evergreenExtensionPeriod) {
			this.evergreenExtensionPeriod = evergreenExtensionPeriod==null?null:evergreenExtensionPeriod.toBuilder();
			return this;
		}
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder setEvergreenRollFrequency(CalculationPeriodFrequency evergreenRollFrequency) {
			this.evergreenRollFrequency = evergreenRollFrequency==null?null:evergreenRollFrequency.toBuilder();
			return this;
		}
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation) {
			this.followUpConfirmation = followUpConfirmation==null?null:followUpConfirmation;
			return this;
		}
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder setBuyer(CounterpartyRoleEnum buyer) {
			this.buyer = buyer==null?null:buyer;
			return this;
		}
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder setSeller(CounterpartyRoleEnum seller) {
			this.seller = seller==null?null:seller;
			return this;
		}
		
		@Override
		public EvergreenProvision build() {
			return new EvergreenProvision.EvergreenProvisionImpl(this);
		}
		
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder prune() {
			super.prune();
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (bermudaExercise!=null && !bermudaExercise.prune().hasData()) bermudaExercise = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (evergreenExtensionPeriod!=null && !evergreenExtensionPeriod.prune().hasData()) evergreenExtensionPeriod = null;
			if (evergreenRollFrequency!=null && !evergreenRollFrequency.prune().hasData()) evergreenRollFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getBermudaExercise()!=null && getBermudaExercise().hasData()) return true;
			if (getCallingParty()!=null) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getEvergreenExtensionPeriod()!=null && getEvergreenExtensionPeriod().hasData()) return true;
			if (getEvergreenRollFrequency()!=null && getEvergreenRollFrequency().hasData()) return true;
			if (getFollowUpConfirmation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EvergreenProvision.EvergreenProvisionBuilder o = (EvergreenProvision.EvergreenProvisionBuilder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getBermudaExercise(), o.getBermudaExercise(), this::setBermudaExercise);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getEvergreenExtensionPeriod(), o.getEvergreenExtensionPeriod(), this::setEvergreenExtensionPeriod);
			merger.mergeRosetta(getEvergreenRollFrequency(), o.getEvergreenRollFrequency(), this::setEvergreenRollFrequency);
			
			merger.mergeBasic(getCallingParty(), o.getCallingParty(), this::setCallingParty);
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EvergreenProvision _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(bermudaExercise, _that.getBermudaExercise())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(evergreenExtensionPeriod, _that.getEvergreenExtensionPeriod())) return false;
			if (!Objects.equals(evergreenRollFrequency, _that.getEvergreenRollFrequency())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (bermudaExercise != null ? bermudaExercise.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (evergreenExtensionPeriod != null ? evergreenExtensionPeriod.hashCode() : 0);
			_result = 31 * _result + (evergreenRollFrequency != null ? evergreenRollFrequency.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EvergreenProvisionBuilder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"bermudaExercise=" + this.bermudaExercise + ", " +
				"callingParty=" + this.callingParty + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"evergreenExtensionPeriod=" + this.evergreenExtensionPeriod + ", " +
				"evergreenRollFrequency=" + this.evergreenRollFrequency + ", " +
				"followUpConfirmation=" + this.followUpConfirmation +
			'}' + " " + super.toString();
		}
	}
}
