package cdm.product.template;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilder;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilderImpl;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerImpl;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.common.schedule.FinalCalculationPeriodDateAdjustment;
import cdm.product.common.settlement.SimplePayment;
import cdm.product.template.meta.CancelableProvisionMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A data defining:  the right of a party to cancel a swap transaction on the specified exercise dates. The provision is for &#39;walk-away&#39; cancellation (i.e. the fair value of the swap is not paid). A fee payable on exercise can be specified. As a difference from the FpML construct, the canonical model extends the BuyerSeller class.
 * @version ${project.version}
 */
@RosettaClass

public interface CancelableProvision extends BuyerSeller {
	CancelableProvision build();
	CancelableProvision.CancelableProvisionBuilder toBuilder();
	
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
	 * The adjusted dates associated with a cancelable provision. These dates have been adjusted for any applicable business day convention.
	 */
	CancelableProvisionAdjustedDates getCancelableProvisionAdjustedDates();
	/**
	 * European exercise. FpML implementations consists in an exercise substitution group.
	 */
	EuropeanExercise getEuropeanExercise();
	/**
	 * Definition of the party to whom notice of exercise should be given.
	 */
	ExerciseNotice getExerciseNotice();
	/**
	 * Business date convention adjustment to final payment period per leg (swapStream) upon exercise event. The adjustments can be made in-line with leg level BDC&#39;s or they can be specified separately.
	 */
	List<? extends FinalCalculationPeriodDateAdjustment> getFinalCalculationPeriodDateAdjustment();
	/**
	 * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller&#39;s agent.
	 */
	Boolean getFollowUpConfirmation();
	/**
	 * An initial fee for the cancelable option.
	 */
	SimplePayment getInitialFee();
	final static CancelableProvisionMeta metaData = new CancelableProvisionMeta();
	
	@Override
	default RosettaMetaData<? extends CancelableProvision> metaData() {
		return metaData;
	} 
			
	static CancelableProvision.CancelableProvisionBuilder builder() {
		return new CancelableProvision.CancelableProvisionBuilderImpl();
	}
	
	default Class<? extends CancelableProvision> getType() {
		return CancelableProvision.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.party.BuyerSeller.super.process(path, processor);
		processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		
		processRosetta(path.newSubPath("americanExercise"), processor, AmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("bermudaExercise"), processor, BermudaExercise.class, getBermudaExercise());
		processRosetta(path.newSubPath("cancelableProvisionAdjustedDates"), processor, CancelableProvisionAdjustedDates.class, getCancelableProvisionAdjustedDates());
		processRosetta(path.newSubPath("europeanExercise"), processor, EuropeanExercise.class, getEuropeanExercise());
		processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.class, getExerciseNotice());
		processRosetta(path.newSubPath("finalCalculationPeriodDateAdjustment"), processor, FinalCalculationPeriodDateAdjustment.class, getFinalCalculationPeriodDateAdjustment());
		processRosetta(path.newSubPath("initialFee"), processor, SimplePayment.class, getInitialFee());
	}
	
	
	interface CancelableProvisionBuilder extends CancelableProvision, BuyerSeller.BuyerSellerBuilder, RosettaModelObjectBuilder {
		AmericanExercise.AmericanExerciseBuilder getOrCreateAmericanExercise();
		AmericanExercise.AmericanExerciseBuilder getAmericanExercise();
		BermudaExercise.BermudaExerciseBuilder getOrCreateBermudaExercise();
		BermudaExercise.BermudaExerciseBuilder getBermudaExercise();
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getOrCreateCancelableProvisionAdjustedDates();
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getCancelableProvisionAdjustedDates();
		EuropeanExercise.EuropeanExerciseBuilder getOrCreateEuropeanExercise();
		EuropeanExercise.EuropeanExerciseBuilder getEuropeanExercise();
		ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice();
		ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice();
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder getOrCreateFinalCalculationPeriodDateAdjustment(int _index);
		List<? extends FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> getFinalCalculationPeriodDateAdjustment();
		SimplePayment.SimplePaymentBuilder getOrCreateInitialFee();
		SimplePayment.SimplePaymentBuilder getInitialFee();
		CancelableProvision.CancelableProvisionBuilder setAmericanExercise(AmericanExercise americanExercise);
		CancelableProvision.CancelableProvisionBuilder setBermudaExercise(BermudaExercise bermudaExercise);
		CancelableProvision.CancelableProvisionBuilder setCallingParty(CallingPartyEnum callingParty);
		CancelableProvision.CancelableProvisionBuilder setCancelableProvisionAdjustedDates(CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates);
		CancelableProvision.CancelableProvisionBuilder setEuropeanExercise(EuropeanExercise europeanExercise);
		CancelableProvision.CancelableProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment, int _idx);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment);
		CancelableProvision.CancelableProvisionBuilder setFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment);
		CancelableProvision.CancelableProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		CancelableProvision.CancelableProvisionBuilder setInitialFee(SimplePayment initialFee);
		CancelableProvision.CancelableProvisionBuilder setBuyer(CounterpartyRoleEnum buyer);
		CancelableProvision.CancelableProvisionBuilder setSeller(CounterpartyRoleEnum seller);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			BuyerSeller.BuyerSellerBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			
			processRosetta(path.newSubPath("americanExercise"), processor, AmericanExercise.AmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("bermudaExercise"), processor, BermudaExercise.BermudaExerciseBuilder.class, getBermudaExercise());
			processRosetta(path.newSubPath("cancelableProvisionAdjustedDates"), processor, CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder.class, getCancelableProvisionAdjustedDates());
			processRosetta(path.newSubPath("europeanExercise"), processor, EuropeanExercise.EuropeanExerciseBuilder.class, getEuropeanExercise());
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processRosetta(path.newSubPath("finalCalculationPeriodDateAdjustment"), processor, FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder.class, getFinalCalculationPeriodDateAdjustment());
			processRosetta(path.newSubPath("initialFee"), processor, SimplePayment.SimplePaymentBuilder.class, getInitialFee());
		}
		
	}
	
	//CancelableProvision.CancelableProvisionImpl
	class CancelableProvisionImpl extends BuyerSeller.BuyerSellerImpl implements CancelableProvision {
		private final AmericanExercise americanExercise;
		private final BermudaExercise bermudaExercise;
		private final CallingPartyEnum callingParty;
		private final CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates;
		private final EuropeanExercise europeanExercise;
		private final ExerciseNotice exerciseNotice;
		private final List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment;
		private final Boolean followUpConfirmation;
		private final SimplePayment initialFee;
		
		protected CancelableProvisionImpl(CancelableProvision.CancelableProvisionBuilder builder) {
			super(builder);
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.bermudaExercise = ofNullable(builder.getBermudaExercise()).map(f->f.build()).orElse(null);
			this.callingParty = builder.getCallingParty();
			this.cancelableProvisionAdjustedDates = ofNullable(builder.getCancelableProvisionAdjustedDates()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).map(f->f.build()).orElse(null);
			this.finalCalculationPeriodDateAdjustment = ofNullable(builder.getFinalCalculationPeriodDateAdjustment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.initialFee = ofNullable(builder.getInitialFee()).map(f->f.build()).orElse(null);
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
		public CancelableProvisionAdjustedDates getCancelableProvisionAdjustedDates() {
			return cancelableProvisionAdjustedDates;
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
		public List<? extends FinalCalculationPeriodDateAdjustment> getFinalCalculationPeriodDateAdjustment() {
			return finalCalculationPeriodDateAdjustment;
		}
		
		@Override
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		public SimplePayment getInitialFee() {
			return initialFee;
		}
		
		@Override
		public CancelableProvision build() {
			return this;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder toBuilder() {
			CancelableProvision.CancelableProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CancelableProvision.CancelableProvisionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getBermudaExercise()).ifPresent(builder::setBermudaExercise);
			ofNullable(getCallingParty()).ifPresent(builder::setCallingParty);
			ofNullable(getCancelableProvisionAdjustedDates()).ifPresent(builder::setCancelableProvisionAdjustedDates);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getFinalCalculationPeriodDateAdjustment()).ifPresent(builder::setFinalCalculationPeriodDateAdjustment);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getInitialFee()).ifPresent(builder::setInitialFee);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CancelableProvision _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(bermudaExercise, _that.getBermudaExercise())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(cancelableProvisionAdjustedDates, _that.getCancelableProvisionAdjustedDates())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!ListEquals.listEquals(finalCalculationPeriodDateAdjustment, _that.getFinalCalculationPeriodDateAdjustment())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(initialFee, _that.getInitialFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (bermudaExercise != null ? bermudaExercise.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cancelableProvisionAdjustedDates != null ? cancelableProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (finalCalculationPeriodDateAdjustment != null ? finalCalculationPeriodDateAdjustment.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (initialFee != null ? initialFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancelableProvision {" +
				"americanExercise=" + this.americanExercise + ", " +
				"bermudaExercise=" + this.bermudaExercise + ", " +
				"callingParty=" + this.callingParty + ", " +
				"cancelableProvisionAdjustedDates=" + this.cancelableProvisionAdjustedDates + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"finalCalculationPeriodDateAdjustment=" + this.finalCalculationPeriodDateAdjustment + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"initialFee=" + this.initialFee +
			'}' + " " + super.toString();
		}
	}
	
	//CancelableProvision.CancelableProvisionBuilderImpl
	class CancelableProvisionBuilderImpl extends BuyerSeller.BuyerSellerBuilderImpl  implements CancelableProvision.CancelableProvisionBuilder {
	
		protected AmericanExercise.AmericanExerciseBuilder americanExercise;
		protected BermudaExercise.BermudaExerciseBuilder bermudaExercise;
		protected CallingPartyEnum callingParty;
		protected CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder cancelableProvisionAdjustedDates;
		protected EuropeanExercise.EuropeanExerciseBuilder europeanExercise;
		protected ExerciseNotice.ExerciseNoticeBuilder exerciseNotice;
		protected List<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> finalCalculationPeriodDateAdjustment = new ArrayList<>();
		protected Boolean followUpConfirmation;
		protected SimplePayment.SimplePaymentBuilder initialFee;
	
		public CancelableProvisionBuilderImpl() {
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
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getCancelableProvisionAdjustedDates() {
			return cancelableProvisionAdjustedDates;
		}
		
		@Override
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getOrCreateCancelableProvisionAdjustedDates() {
			CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder result;
			if (cancelableProvisionAdjustedDates!=null) {
				result = cancelableProvisionAdjustedDates;
			}
			else {
				result = cancelableProvisionAdjustedDates = CancelableProvisionAdjustedDates.builder();
			}
			
			return result;
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
		public List<? extends FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> getFinalCalculationPeriodDateAdjustment() {
			return finalCalculationPeriodDateAdjustment;
		}
		
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder getOrCreateFinalCalculationPeriodDateAdjustment(int _index) {
		
			if (finalCalculationPeriodDateAdjustment==null) {
				this.finalCalculationPeriodDateAdjustment = new ArrayList<>();
			}
			FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder result;
			return getIndex(finalCalculationPeriodDateAdjustment, _index, () -> {
						FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder newFinalCalculationPeriodDateAdjustment = FinalCalculationPeriodDateAdjustment.builder();
						return newFinalCalculationPeriodDateAdjustment;
					});
		}
		
		@Override
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getInitialFee() {
			return initialFee;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreateInitialFee() {
			SimplePayment.SimplePaymentBuilder result;
			if (initialFee!=null) {
				result = initialFee;
			}
			else {
				result = initialFee = SimplePayment.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CancelableProvision.CancelableProvisionBuilder setAmericanExercise(AmericanExercise americanExercise) {
			this.americanExercise = americanExercise==null?null:americanExercise.toBuilder();
			return this;
		}
		@Override
		public CancelableProvision.CancelableProvisionBuilder setBermudaExercise(BermudaExercise bermudaExercise) {
			this.bermudaExercise = bermudaExercise==null?null:bermudaExercise.toBuilder();
			return this;
		}
		@Override
		public CancelableProvision.CancelableProvisionBuilder setCallingParty(CallingPartyEnum callingParty) {
			this.callingParty = callingParty==null?null:callingParty;
			return this;
		}
		@Override
		public CancelableProvision.CancelableProvisionBuilder setCancelableProvisionAdjustedDates(CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates) {
			this.cancelableProvisionAdjustedDates = cancelableProvisionAdjustedDates==null?null:cancelableProvisionAdjustedDates.toBuilder();
			return this;
		}
		@Override
		public CancelableProvision.CancelableProvisionBuilder setEuropeanExercise(EuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		@Override
		public CancelableProvision.CancelableProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice) {
			this.exerciseNotice = exerciseNotice==null?null:exerciseNotice.toBuilder();
			return this;
		}
		@Override
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment) {
			if (finalCalculationPeriodDateAdjustment!=null) this.finalCalculationPeriodDateAdjustment.add(finalCalculationPeriodDateAdjustment.toBuilder());
			return this;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment, int _idx) {
			getIndex(this.finalCalculationPeriodDateAdjustment, _idx, () -> finalCalculationPeriodDateAdjustment.toBuilder());
			return this;
		}
		@Override 
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustments) {
			if (finalCalculationPeriodDateAdjustments != null) {
				for (FinalCalculationPeriodDateAdjustment toAdd : finalCalculationPeriodDateAdjustments) {
					this.finalCalculationPeriodDateAdjustment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CancelableProvision.CancelableProvisionBuilder setFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustments) {
			if (finalCalculationPeriodDateAdjustments == null)  {
				this.finalCalculationPeriodDateAdjustment = new ArrayList<>();
			}
			else {
				this.finalCalculationPeriodDateAdjustment = finalCalculationPeriodDateAdjustments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation) {
			this.followUpConfirmation = followUpConfirmation==null?null:followUpConfirmation;
			return this;
		}
		@Override
		public CancelableProvision.CancelableProvisionBuilder setInitialFee(SimplePayment initialFee) {
			this.initialFee = initialFee==null?null:initialFee.toBuilder();
			return this;
		}
		@Override
		public CancelableProvision.CancelableProvisionBuilder setBuyer(CounterpartyRoleEnum buyer) {
			this.buyer = buyer==null?null:buyer;
			return this;
		}
		@Override
		public CancelableProvision.CancelableProvisionBuilder setSeller(CounterpartyRoleEnum seller) {
			this.seller = seller==null?null:seller;
			return this;
		}
		
		@Override
		public CancelableProvision build() {
			return new CancelableProvision.CancelableProvisionImpl(this);
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancelableProvision.CancelableProvisionBuilder prune() {
			super.prune();
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (bermudaExercise!=null && !bermudaExercise.prune().hasData()) bermudaExercise = null;
			if (cancelableProvisionAdjustedDates!=null && !cancelableProvisionAdjustedDates.prune().hasData()) cancelableProvisionAdjustedDates = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (exerciseNotice!=null && !exerciseNotice.prune().hasData()) exerciseNotice = null;
			finalCalculationPeriodDateAdjustment = finalCalculationPeriodDateAdjustment.stream().filter(b->b!=null).<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (initialFee!=null && !initialFee.prune().hasData()) initialFee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getBermudaExercise()!=null && getBermudaExercise().hasData()) return true;
			if (getCallingParty()!=null) return true;
			if (getCancelableProvisionAdjustedDates()!=null && getCancelableProvisionAdjustedDates().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getExerciseNotice()!=null && getExerciseNotice().hasData()) return true;
			if (getFinalCalculationPeriodDateAdjustment()!=null && getFinalCalculationPeriodDateAdjustment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFollowUpConfirmation()!=null) return true;
			if (getInitialFee()!=null && getInitialFee().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancelableProvision.CancelableProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CancelableProvision.CancelableProvisionBuilder o = (CancelableProvision.CancelableProvisionBuilder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getBermudaExercise(), o.getBermudaExercise(), this::setBermudaExercise);
			merger.mergeRosetta(getCancelableProvisionAdjustedDates(), o.getCancelableProvisionAdjustedDates(), this::setCancelableProvisionAdjustedDates);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::setExerciseNotice);
			merger.mergeRosetta(getFinalCalculationPeriodDateAdjustment(), o.getFinalCalculationPeriodDateAdjustment(), this::getOrCreateFinalCalculationPeriodDateAdjustment);
			merger.mergeRosetta(getInitialFee(), o.getInitialFee(), this::setInitialFee);
			
			merger.mergeBasic(getCallingParty(), o.getCallingParty(), this::setCallingParty);
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CancelableProvision _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(bermudaExercise, _that.getBermudaExercise())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(cancelableProvisionAdjustedDates, _that.getCancelableProvisionAdjustedDates())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!ListEquals.listEquals(finalCalculationPeriodDateAdjustment, _that.getFinalCalculationPeriodDateAdjustment())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(initialFee, _that.getInitialFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (bermudaExercise != null ? bermudaExercise.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cancelableProvisionAdjustedDates != null ? cancelableProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (finalCalculationPeriodDateAdjustment != null ? finalCalculationPeriodDateAdjustment.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (initialFee != null ? initialFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancelableProvisionBuilder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"bermudaExercise=" + this.bermudaExercise + ", " +
				"callingParty=" + this.callingParty + ", " +
				"cancelableProvisionAdjustedDates=" + this.cancelableProvisionAdjustedDates + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"finalCalculationPeriodDateAdjustment=" + this.finalCalculationPeriodDateAdjustment + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"initialFee=" + this.initialFee +
			'}' + " " + super.toString();
		}
	}
}
