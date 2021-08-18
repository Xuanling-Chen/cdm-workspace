package cdm.product.template;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilder;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilderImpl;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerImpl;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.template.meta.ExtendibleProvisionMeta;
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
 * A data defining:  an option to extend an existing swap transaction on the specified exercise dates for a term ending on the specified new termination date. As a difference from FpML, it extends the BuyerSeller class, which represents the BuyerSeller.model.
 * @version ${project.version}
 */
@RosettaClass

public interface ExtendibleProvision extends BuyerSeller {
	ExtendibleProvision build();
	ExtendibleProvision.ExtendibleProvisionBuilder toBuilder();
	
	/**
	 * American exercise. FpML implementations consists in an exercise substitution group.
	 */
	AmericanExercise getAmericanExercise();
	/**
	 * Bermuda exercise. FpML implementations consists in an exercise substitution group.
	 */
	BermudaExercise getBermudaExercise();
	/**
	 */
	CallingPartyEnum getCallingParty();
	/**
	 * European exercise. FpML implementations consists in an exercise substitution group.
	 */
	EuropeanExercise getEuropeanExercise();
	/**
	 * Definition of the party to whom notice of exercise should be given.
	 */
	ExerciseNotice getExerciseNotice();
	/**
	 * The adjusted dates associated with an extendible provision. These dates have been adjusted for any applicable business day convention.
	 */
	ExtendibleProvisionAdjustedDates getExtendibleProvisionAdjustedDates();
	/**
	 * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller&#39;s agent.
	 */
	Boolean getFollowUpConfirmation();
	final static ExtendibleProvisionMeta metaData = new ExtendibleProvisionMeta();
	
	@Override
	default RosettaMetaData<? extends ExtendibleProvision> metaData() {
		return metaData;
	} 
			
	static ExtendibleProvision.ExtendibleProvisionBuilder builder() {
		return new ExtendibleProvision.ExtendibleProvisionBuilderImpl();
	}
	
	default Class<? extends ExtendibleProvision> getType() {
		return ExtendibleProvision.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.party.BuyerSeller.super.process(path, processor);
		processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		
		processRosetta(path.newSubPath("americanExercise"), processor, AmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("bermudaExercise"), processor, BermudaExercise.class, getBermudaExercise());
		processRosetta(path.newSubPath("europeanExercise"), processor, EuropeanExercise.class, getEuropeanExercise());
		processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.class, getExerciseNotice());
		processRosetta(path.newSubPath("extendibleProvisionAdjustedDates"), processor, ExtendibleProvisionAdjustedDates.class, getExtendibleProvisionAdjustedDates());
	}
	
	
	interface ExtendibleProvisionBuilder extends ExtendibleProvision, BuyerSeller.BuyerSellerBuilder, RosettaModelObjectBuilder {
		AmericanExercise.AmericanExerciseBuilder getOrCreateAmericanExercise();
		AmericanExercise.AmericanExerciseBuilder getAmericanExercise();
		BermudaExercise.BermudaExerciseBuilder getOrCreateBermudaExercise();
		BermudaExercise.BermudaExerciseBuilder getBermudaExercise();
		EuropeanExercise.EuropeanExerciseBuilder getOrCreateEuropeanExercise();
		EuropeanExercise.EuropeanExerciseBuilder getEuropeanExercise();
		ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice();
		ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice();
		ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getOrCreateExtendibleProvisionAdjustedDates();
		ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getExtendibleProvisionAdjustedDates();
		ExtendibleProvision.ExtendibleProvisionBuilder setAmericanExercise(AmericanExercise americanExercise);
		ExtendibleProvision.ExtendibleProvisionBuilder setBermudaExercise(BermudaExercise bermudaExercise);
		ExtendibleProvision.ExtendibleProvisionBuilder setCallingParty(CallingPartyEnum callingParty);
		ExtendibleProvision.ExtendibleProvisionBuilder setEuropeanExercise(EuropeanExercise europeanExercise);
		ExtendibleProvision.ExtendibleProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice);
		ExtendibleProvision.ExtendibleProvisionBuilder setExtendibleProvisionAdjustedDates(ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates);
		ExtendibleProvision.ExtendibleProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		ExtendibleProvision.ExtendibleProvisionBuilder setBuyer(CounterpartyRoleEnum buyer);
		ExtendibleProvision.ExtendibleProvisionBuilder setSeller(CounterpartyRoleEnum seller);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			BuyerSeller.BuyerSellerBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			
			processRosetta(path.newSubPath("americanExercise"), processor, AmericanExercise.AmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("bermudaExercise"), processor, BermudaExercise.BermudaExerciseBuilder.class, getBermudaExercise());
			processRosetta(path.newSubPath("europeanExercise"), processor, EuropeanExercise.EuropeanExerciseBuilder.class, getEuropeanExercise());
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processRosetta(path.newSubPath("extendibleProvisionAdjustedDates"), processor, ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder.class, getExtendibleProvisionAdjustedDates());
		}
		
	}
	
	//ExtendibleProvision.ExtendibleProvisionImpl
	class ExtendibleProvisionImpl extends BuyerSeller.BuyerSellerImpl implements ExtendibleProvision {
		private final AmericanExercise americanExercise;
		private final BermudaExercise bermudaExercise;
		private final CallingPartyEnum callingParty;
		private final EuropeanExercise europeanExercise;
		private final ExerciseNotice exerciseNotice;
		private final ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates;
		private final Boolean followUpConfirmation;
		
		protected ExtendibleProvisionImpl(ExtendibleProvision.ExtendibleProvisionBuilder builder) {
			super(builder);
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.bermudaExercise = ofNullable(builder.getBermudaExercise()).map(f->f.build()).orElse(null);
			this.callingParty = builder.getCallingParty();
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).map(f->f.build()).orElse(null);
			this.extendibleProvisionAdjustedDates = ofNullable(builder.getExtendibleProvisionAdjustedDates()).map(f->f.build()).orElse(null);
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
		public ExerciseNotice getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
		public ExtendibleProvisionAdjustedDates getExtendibleProvisionAdjustedDates() {
			return extendibleProvisionAdjustedDates;
		}
		
		@Override
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		public ExtendibleProvision build() {
			return this;
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder toBuilder() {
			ExtendibleProvision.ExtendibleProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExtendibleProvision.ExtendibleProvisionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getBermudaExercise()).ifPresent(builder::setBermudaExercise);
			ofNullable(getCallingParty()).ifPresent(builder::setCallingParty);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getExtendibleProvisionAdjustedDates()).ifPresent(builder::setExtendibleProvisionAdjustedDates);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExtendibleProvision _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(bermudaExercise, _that.getBermudaExercise())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(extendibleProvisionAdjustedDates, _that.getExtendibleProvisionAdjustedDates())) return false;
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
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (extendibleProvisionAdjustedDates != null ? extendibleProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtendibleProvision {" +
				"americanExercise=" + this.americanExercise + ", " +
				"bermudaExercise=" + this.bermudaExercise + ", " +
				"callingParty=" + this.callingParty + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"extendibleProvisionAdjustedDates=" + this.extendibleProvisionAdjustedDates + ", " +
				"followUpConfirmation=" + this.followUpConfirmation +
			'}' + " " + super.toString();
		}
	}
	
	//ExtendibleProvision.ExtendibleProvisionBuilderImpl
	class ExtendibleProvisionBuilderImpl extends BuyerSeller.BuyerSellerBuilderImpl  implements ExtendibleProvision.ExtendibleProvisionBuilder {
	
		protected AmericanExercise.AmericanExerciseBuilder americanExercise;
		protected BermudaExercise.BermudaExerciseBuilder bermudaExercise;
		protected CallingPartyEnum callingParty;
		protected EuropeanExercise.EuropeanExerciseBuilder europeanExercise;
		protected ExerciseNotice.ExerciseNoticeBuilder exerciseNotice;
		protected ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder extendibleProvisionAdjustedDates;
		protected Boolean followUpConfirmation;
	
		public ExtendibleProvisionBuilderImpl() {
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
		public ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice() {
			ExerciseNotice.ExerciseNoticeBuilder result;
			if (exerciseNotice!=null) {
				result = exerciseNotice;
			}
			else {
				result = exerciseNotice = ExerciseNotice.builder();
			}
			
			return result;
		}
		
		@Override
		public ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getExtendibleProvisionAdjustedDates() {
			return extendibleProvisionAdjustedDates;
		}
		
		@Override
		public ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getOrCreateExtendibleProvisionAdjustedDates() {
			ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder result;
			if (extendibleProvisionAdjustedDates!=null) {
				result = extendibleProvisionAdjustedDates;
			}
			else {
				result = extendibleProvisionAdjustedDates = ExtendibleProvisionAdjustedDates.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
	
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setAmericanExercise(AmericanExercise americanExercise) {
			this.americanExercise = americanExercise==null?null:americanExercise.toBuilder();
			return this;
		}
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setBermudaExercise(BermudaExercise bermudaExercise) {
			this.bermudaExercise = bermudaExercise==null?null:bermudaExercise.toBuilder();
			return this;
		}
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setCallingParty(CallingPartyEnum callingParty) {
			this.callingParty = callingParty==null?null:callingParty;
			return this;
		}
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setEuropeanExercise(EuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice) {
			this.exerciseNotice = exerciseNotice==null?null:exerciseNotice.toBuilder();
			return this;
		}
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setExtendibleProvisionAdjustedDates(ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates) {
			this.extendibleProvisionAdjustedDates = extendibleProvisionAdjustedDates==null?null:extendibleProvisionAdjustedDates.toBuilder();
			return this;
		}
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation) {
			this.followUpConfirmation = followUpConfirmation==null?null:followUpConfirmation;
			return this;
		}
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setBuyer(CounterpartyRoleEnum buyer) {
			this.buyer = buyer==null?null:buyer;
			return this;
		}
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setSeller(CounterpartyRoleEnum seller) {
			this.seller = seller==null?null:seller;
			return this;
		}
		
		@Override
		public ExtendibleProvision build() {
			return new ExtendibleProvision.ExtendibleProvisionImpl(this);
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder prune() {
			super.prune();
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (bermudaExercise!=null && !bermudaExercise.prune().hasData()) bermudaExercise = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (exerciseNotice!=null && !exerciseNotice.prune().hasData()) exerciseNotice = null;
			if (extendibleProvisionAdjustedDates!=null && !extendibleProvisionAdjustedDates.prune().hasData()) extendibleProvisionAdjustedDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getBermudaExercise()!=null && getBermudaExercise().hasData()) return true;
			if (getCallingParty()!=null) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getExerciseNotice()!=null && getExerciseNotice().hasData()) return true;
			if (getExtendibleProvisionAdjustedDates()!=null && getExtendibleProvisionAdjustedDates().hasData()) return true;
			if (getFollowUpConfirmation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExtendibleProvision.ExtendibleProvisionBuilder o = (ExtendibleProvision.ExtendibleProvisionBuilder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getBermudaExercise(), o.getBermudaExercise(), this::setBermudaExercise);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::setExerciseNotice);
			merger.mergeRosetta(getExtendibleProvisionAdjustedDates(), o.getExtendibleProvisionAdjustedDates(), this::setExtendibleProvisionAdjustedDates);
			
			merger.mergeBasic(getCallingParty(), o.getCallingParty(), this::setCallingParty);
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExtendibleProvision _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(bermudaExercise, _that.getBermudaExercise())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(extendibleProvisionAdjustedDates, _that.getExtendibleProvisionAdjustedDates())) return false;
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
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (extendibleProvisionAdjustedDates != null ? extendibleProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtendibleProvisionBuilder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"bermudaExercise=" + this.bermudaExercise + ", " +
				"callingParty=" + this.callingParty + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"extendibleProvisionAdjustedDates=" + this.extendibleProvisionAdjustedDates + ", " +
				"followUpConfirmation=" + this.followUpConfirmation +
			'}' + " " + super.toString();
		}
	}
}
