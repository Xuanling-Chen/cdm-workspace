package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CalculationAndTimingMeta;
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
 * A class to specify the Calculation, Valuation and Timing terms specific to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface CalculationAndTiming extends RosettaModelObject {
	CalculationAndTiming build();
	CalculationAndTiming.CalculationAndTimingBuilder toBuilder();
	
	/**
	 * The specification of bespoke Calculation Date terms for the purposes of Initial or Variation Margin by the parties to the agreement.
	 */
	BespokeCalculationDate getBespokeCalculationDate();
	/**
	 * Bespoke terms to describe the time as of which such party (or the Calculation Agent (IM) (if applicale)) computes its end of day valuations of derivatives transactions.
	 */
	BespokeCalculationTime getBespokeCalculationTime();
	/**
	 * The calculation agent terms applicable to the agreement.
	 */
	CalculationAgentTerms getCalculationAgentTerms();
	/**
	 * The specified location where the credit exposure will be calculated by the respective parties.
	 */
	CalculationDateLocation getCalculationDateLocation();
	/**
	 * Cash Settlement Day has the meaning specified in ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, Paragraph 4(b)(i), unless otherwise specified as part of this attribute.
	 */
	String getCashSettlementDay();
	/**
	 * The bespoke Collateral Valuation Agent terms applicable to the agreement.
	 */
	CollateralValuationAgent getCollateralValuationAgent();
	/**
	 * The time by which a demand for the Transfer of Eligible Credit Support (IM) or Posted Credit Support (IM) needs to be made in order for the transfer to take place in accordance with the Transfer Timing provisions.
	 */
	NotificationTime getNotificationTime();
	/**
	 * Securities Settlement Day has the meaning specified in ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, Paragraph 12, unless otherwise specified as part of this attribute.
	 */
	String getSecuritiesSettlementDay();
	final static CalculationAndTimingMeta metaData = new CalculationAndTimingMeta();
	
	@Override
	default RosettaMetaData<? extends CalculationAndTiming> metaData() {
		return metaData;
	} 
			
	static CalculationAndTiming.CalculationAndTimingBuilder builder() {
		return new CalculationAndTiming.CalculationAndTimingBuilderImpl();
	}
	
	default Class<? extends CalculationAndTiming> getType() {
		return CalculationAndTiming.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cashSettlementDay"), String.class, getCashSettlementDay(), this);
		processor.processBasic(path.newSubPath("securitiesSettlementDay"), String.class, getSecuritiesSettlementDay(), this);
		
		processRosetta(path.newSubPath("bespokeCalculationDate"), processor, BespokeCalculationDate.class, getBespokeCalculationDate());
		processRosetta(path.newSubPath("bespokeCalculationTime"), processor, BespokeCalculationTime.class, getBespokeCalculationTime());
		processRosetta(path.newSubPath("calculationAgentTerms"), processor, CalculationAgentTerms.class, getCalculationAgentTerms());
		processRosetta(path.newSubPath("calculationDateLocation"), processor, CalculationDateLocation.class, getCalculationDateLocation());
		processRosetta(path.newSubPath("collateralValuationAgent"), processor, CollateralValuationAgent.class, getCollateralValuationAgent());
		processRosetta(path.newSubPath("notificationTime"), processor, NotificationTime.class, getNotificationTime());
	}
	
	
	interface CalculationAndTimingBuilder extends CalculationAndTiming, RosettaModelObjectBuilder {
		BespokeCalculationDate.BespokeCalculationDateBuilder getOrCreateBespokeCalculationDate();
		BespokeCalculationDate.BespokeCalculationDateBuilder getBespokeCalculationDate();
		BespokeCalculationTime.BespokeCalculationTimeBuilder getOrCreateBespokeCalculationTime();
		BespokeCalculationTime.BespokeCalculationTimeBuilder getBespokeCalculationTime();
		CalculationAgentTerms.CalculationAgentTermsBuilder getOrCreateCalculationAgentTerms();
		CalculationAgentTerms.CalculationAgentTermsBuilder getCalculationAgentTerms();
		CalculationDateLocation.CalculationDateLocationBuilder getOrCreateCalculationDateLocation();
		CalculationDateLocation.CalculationDateLocationBuilder getCalculationDateLocation();
		CollateralValuationAgent.CollateralValuationAgentBuilder getOrCreateCollateralValuationAgent();
		CollateralValuationAgent.CollateralValuationAgentBuilder getCollateralValuationAgent();
		NotificationTime.NotificationTimeBuilder getOrCreateNotificationTime();
		NotificationTime.NotificationTimeBuilder getNotificationTime();
		CalculationAndTiming.CalculationAndTimingBuilder setBespokeCalculationDate(BespokeCalculationDate bespokeCalculationDate);
		CalculationAndTiming.CalculationAndTimingBuilder setBespokeCalculationTime(BespokeCalculationTime bespokeCalculationTime);
		CalculationAndTiming.CalculationAndTimingBuilder setCalculationAgentTerms(CalculationAgentTerms calculationAgentTerms);
		CalculationAndTiming.CalculationAndTimingBuilder setCalculationDateLocation(CalculationDateLocation calculationDateLocation);
		CalculationAndTiming.CalculationAndTimingBuilder setCashSettlementDay(String cashSettlementDay);
		CalculationAndTiming.CalculationAndTimingBuilder setCollateralValuationAgent(CollateralValuationAgent collateralValuationAgent);
		CalculationAndTiming.CalculationAndTimingBuilder setNotificationTime(NotificationTime notificationTime);
		CalculationAndTiming.CalculationAndTimingBuilder setSecuritiesSettlementDay(String securitiesSettlementDay);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("cashSettlementDay"), String.class, getCashSettlementDay(), this);
			processor.processBasic(path.newSubPath("securitiesSettlementDay"), String.class, getSecuritiesSettlementDay(), this);
			
			processRosetta(path.newSubPath("bespokeCalculationDate"), processor, BespokeCalculationDate.BespokeCalculationDateBuilder.class, getBespokeCalculationDate());
			processRosetta(path.newSubPath("bespokeCalculationTime"), processor, BespokeCalculationTime.BespokeCalculationTimeBuilder.class, getBespokeCalculationTime());
			processRosetta(path.newSubPath("calculationAgentTerms"), processor, CalculationAgentTerms.CalculationAgentTermsBuilder.class, getCalculationAgentTerms());
			processRosetta(path.newSubPath("calculationDateLocation"), processor, CalculationDateLocation.CalculationDateLocationBuilder.class, getCalculationDateLocation());
			processRosetta(path.newSubPath("collateralValuationAgent"), processor, CollateralValuationAgent.CollateralValuationAgentBuilder.class, getCollateralValuationAgent());
			processRosetta(path.newSubPath("notificationTime"), processor, NotificationTime.NotificationTimeBuilder.class, getNotificationTime());
		}
		
	}
	
	//CalculationAndTiming.CalculationAndTimingImpl
	class CalculationAndTimingImpl implements CalculationAndTiming {
		private final BespokeCalculationDate bespokeCalculationDate;
		private final BespokeCalculationTime bespokeCalculationTime;
		private final CalculationAgentTerms calculationAgentTerms;
		private final CalculationDateLocation calculationDateLocation;
		private final String cashSettlementDay;
		private final CollateralValuationAgent collateralValuationAgent;
		private final NotificationTime notificationTime;
		private final String securitiesSettlementDay;
		
		protected CalculationAndTimingImpl(CalculationAndTiming.CalculationAndTimingBuilder builder) {
			this.bespokeCalculationDate = ofNullable(builder.getBespokeCalculationDate()).map(f->f.build()).orElse(null);
			this.bespokeCalculationTime = ofNullable(builder.getBespokeCalculationTime()).map(f->f.build()).orElse(null);
			this.calculationAgentTerms = ofNullable(builder.getCalculationAgentTerms()).map(f->f.build()).orElse(null);
			this.calculationDateLocation = ofNullable(builder.getCalculationDateLocation()).map(f->f.build()).orElse(null);
			this.cashSettlementDay = builder.getCashSettlementDay();
			this.collateralValuationAgent = ofNullable(builder.getCollateralValuationAgent()).map(f->f.build()).orElse(null);
			this.notificationTime = ofNullable(builder.getNotificationTime()).map(f->f.build()).orElse(null);
			this.securitiesSettlementDay = builder.getSecuritiesSettlementDay();
		}
		
		@Override
		public BespokeCalculationDate getBespokeCalculationDate() {
			return bespokeCalculationDate;
		}
		
		@Override
		public BespokeCalculationTime getBespokeCalculationTime() {
			return bespokeCalculationTime;
		}
		
		@Override
		public CalculationAgentTerms getCalculationAgentTerms() {
			return calculationAgentTerms;
		}
		
		@Override
		public CalculationDateLocation getCalculationDateLocation() {
			return calculationDateLocation;
		}
		
		@Override
		public String getCashSettlementDay() {
			return cashSettlementDay;
		}
		
		@Override
		public CollateralValuationAgent getCollateralValuationAgent() {
			return collateralValuationAgent;
		}
		
		@Override
		public NotificationTime getNotificationTime() {
			return notificationTime;
		}
		
		@Override
		public String getSecuritiesSettlementDay() {
			return securitiesSettlementDay;
		}
		
		@Override
		public CalculationAndTiming build() {
			return this;
		}
		
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder toBuilder() {
			CalculationAndTiming.CalculationAndTimingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationAndTiming.CalculationAndTimingBuilder builder) {
			ofNullable(getBespokeCalculationDate()).ifPresent(builder::setBespokeCalculationDate);
			ofNullable(getBespokeCalculationTime()).ifPresent(builder::setBespokeCalculationTime);
			ofNullable(getCalculationAgentTerms()).ifPresent(builder::setCalculationAgentTerms);
			ofNullable(getCalculationDateLocation()).ifPresent(builder::setCalculationDateLocation);
			ofNullable(getCashSettlementDay()).ifPresent(builder::setCashSettlementDay);
			ofNullable(getCollateralValuationAgent()).ifPresent(builder::setCollateralValuationAgent);
			ofNullable(getNotificationTime()).ifPresent(builder::setNotificationTime);
			ofNullable(getSecuritiesSettlementDay()).ifPresent(builder::setSecuritiesSettlementDay);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAndTiming _that = getType().cast(o);
		
			if (!Objects.equals(bespokeCalculationDate, _that.getBespokeCalculationDate())) return false;
			if (!Objects.equals(bespokeCalculationTime, _that.getBespokeCalculationTime())) return false;
			if (!Objects.equals(calculationAgentTerms, _that.getCalculationAgentTerms())) return false;
			if (!Objects.equals(calculationDateLocation, _that.getCalculationDateLocation())) return false;
			if (!Objects.equals(cashSettlementDay, _that.getCashSettlementDay())) return false;
			if (!Objects.equals(collateralValuationAgent, _that.getCollateralValuationAgent())) return false;
			if (!Objects.equals(notificationTime, _that.getNotificationTime())) return false;
			if (!Objects.equals(securitiesSettlementDay, _that.getSecuritiesSettlementDay())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeCalculationDate != null ? bespokeCalculationDate.hashCode() : 0);
			_result = 31 * _result + (bespokeCalculationTime != null ? bespokeCalculationTime.hashCode() : 0);
			_result = 31 * _result + (calculationAgentTerms != null ? calculationAgentTerms.hashCode() : 0);
			_result = 31 * _result + (calculationDateLocation != null ? calculationDateLocation.hashCode() : 0);
			_result = 31 * _result + (cashSettlementDay != null ? cashSettlementDay.hashCode() : 0);
			_result = 31 * _result + (collateralValuationAgent != null ? collateralValuationAgent.hashCode() : 0);
			_result = 31 * _result + (notificationTime != null ? notificationTime.hashCode() : 0);
			_result = 31 * _result + (securitiesSettlementDay != null ? securitiesSettlementDay.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAndTiming {" +
				"bespokeCalculationDate=" + this.bespokeCalculationDate + ", " +
				"bespokeCalculationTime=" + this.bespokeCalculationTime + ", " +
				"calculationAgentTerms=" + this.calculationAgentTerms + ", " +
				"calculationDateLocation=" + this.calculationDateLocation + ", " +
				"cashSettlementDay=" + this.cashSettlementDay + ", " +
				"collateralValuationAgent=" + this.collateralValuationAgent + ", " +
				"notificationTime=" + this.notificationTime + ", " +
				"securitiesSettlementDay=" + this.securitiesSettlementDay +
			'}';
		}
	}
	
	//CalculationAndTiming.CalculationAndTimingBuilderImpl
	class CalculationAndTimingBuilderImpl implements CalculationAndTiming.CalculationAndTimingBuilder {
	
		protected BespokeCalculationDate.BespokeCalculationDateBuilder bespokeCalculationDate;
		protected BespokeCalculationTime.BespokeCalculationTimeBuilder bespokeCalculationTime;
		protected CalculationAgentTerms.CalculationAgentTermsBuilder calculationAgentTerms;
		protected CalculationDateLocation.CalculationDateLocationBuilder calculationDateLocation;
		protected String cashSettlementDay;
		protected CollateralValuationAgent.CollateralValuationAgentBuilder collateralValuationAgent;
		protected NotificationTime.NotificationTimeBuilder notificationTime;
		protected String securitiesSettlementDay;
	
		public CalculationAndTimingBuilderImpl() {
		}
	
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder getBespokeCalculationDate() {
			return bespokeCalculationDate;
		}
		
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder getOrCreateBespokeCalculationDate() {
			BespokeCalculationDate.BespokeCalculationDateBuilder result;
			if (bespokeCalculationDate!=null) {
				result = bespokeCalculationDate;
			}
			else {
				result = bespokeCalculationDate = BespokeCalculationDate.builder();
			}
			
			return result;
		}
		
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder getBespokeCalculationTime() {
			return bespokeCalculationTime;
		}
		
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder getOrCreateBespokeCalculationTime() {
			BespokeCalculationTime.BespokeCalculationTimeBuilder result;
			if (bespokeCalculationTime!=null) {
				result = bespokeCalculationTime;
			}
			else {
				result = bespokeCalculationTime = BespokeCalculationTime.builder();
			}
			
			return result;
		}
		
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder getCalculationAgentTerms() {
			return calculationAgentTerms;
		}
		
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder getOrCreateCalculationAgentTerms() {
			CalculationAgentTerms.CalculationAgentTermsBuilder result;
			if (calculationAgentTerms!=null) {
				result = calculationAgentTerms;
			}
			else {
				result = calculationAgentTerms = CalculationAgentTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder getCalculationDateLocation() {
			return calculationDateLocation;
		}
		
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder getOrCreateCalculationDateLocation() {
			CalculationDateLocation.CalculationDateLocationBuilder result;
			if (calculationDateLocation!=null) {
				result = calculationDateLocation;
			}
			else {
				result = calculationDateLocation = CalculationDateLocation.builder();
			}
			
			return result;
		}
		
		@Override
		public String getCashSettlementDay() {
			return cashSettlementDay;
		}
		
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder getCollateralValuationAgent() {
			return collateralValuationAgent;
		}
		
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder getOrCreateCollateralValuationAgent() {
			CollateralValuationAgent.CollateralValuationAgentBuilder result;
			if (collateralValuationAgent!=null) {
				result = collateralValuationAgent;
			}
			else {
				result = collateralValuationAgent = CollateralValuationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder getNotificationTime() {
			return notificationTime;
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder getOrCreateNotificationTime() {
			NotificationTime.NotificationTimeBuilder result;
			if (notificationTime!=null) {
				result = notificationTime;
			}
			else {
				result = notificationTime = NotificationTime.builder();
			}
			
			return result;
		}
		
		@Override
		public String getSecuritiesSettlementDay() {
			return securitiesSettlementDay;
		}
		
	
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setBespokeCalculationDate(BespokeCalculationDate bespokeCalculationDate) {
			this.bespokeCalculationDate = bespokeCalculationDate==null?null:bespokeCalculationDate.toBuilder();
			return this;
		}
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setBespokeCalculationTime(BespokeCalculationTime bespokeCalculationTime) {
			this.bespokeCalculationTime = bespokeCalculationTime==null?null:bespokeCalculationTime.toBuilder();
			return this;
		}
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setCalculationAgentTerms(CalculationAgentTerms calculationAgentTerms) {
			this.calculationAgentTerms = calculationAgentTerms==null?null:calculationAgentTerms.toBuilder();
			return this;
		}
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setCalculationDateLocation(CalculationDateLocation calculationDateLocation) {
			this.calculationDateLocation = calculationDateLocation==null?null:calculationDateLocation.toBuilder();
			return this;
		}
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setCashSettlementDay(String cashSettlementDay) {
			this.cashSettlementDay = cashSettlementDay==null?null:cashSettlementDay;
			return this;
		}
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setCollateralValuationAgent(CollateralValuationAgent collateralValuationAgent) {
			this.collateralValuationAgent = collateralValuationAgent==null?null:collateralValuationAgent.toBuilder();
			return this;
		}
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setNotificationTime(NotificationTime notificationTime) {
			this.notificationTime = notificationTime==null?null:notificationTime.toBuilder();
			return this;
		}
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setSecuritiesSettlementDay(String securitiesSettlementDay) {
			this.securitiesSettlementDay = securitiesSettlementDay==null?null:securitiesSettlementDay;
			return this;
		}
		
		@Override
		public CalculationAndTiming build() {
			return new CalculationAndTiming.CalculationAndTimingImpl(this);
		}
		
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder prune() {
			if (bespokeCalculationDate!=null && !bespokeCalculationDate.prune().hasData()) bespokeCalculationDate = null;
			if (bespokeCalculationTime!=null && !bespokeCalculationTime.prune().hasData()) bespokeCalculationTime = null;
			if (calculationAgentTerms!=null && !calculationAgentTerms.prune().hasData()) calculationAgentTerms = null;
			if (calculationDateLocation!=null && !calculationDateLocation.prune().hasData()) calculationDateLocation = null;
			if (collateralValuationAgent!=null && !collateralValuationAgent.prune().hasData()) collateralValuationAgent = null;
			if (notificationTime!=null && !notificationTime.prune().hasData()) notificationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBespokeCalculationDate()!=null && getBespokeCalculationDate().hasData()) return true;
			if (getBespokeCalculationTime()!=null && getBespokeCalculationTime().hasData()) return true;
			if (getCalculationAgentTerms()!=null && getCalculationAgentTerms().hasData()) return true;
			if (getCalculationDateLocation()!=null && getCalculationDateLocation().hasData()) return true;
			if (getCashSettlementDay()!=null) return true;
			if (getCollateralValuationAgent()!=null && getCollateralValuationAgent().hasData()) return true;
			if (getNotificationTime()!=null && getNotificationTime().hasData()) return true;
			if (getSecuritiesSettlementDay()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationAndTiming.CalculationAndTimingBuilder o = (CalculationAndTiming.CalculationAndTimingBuilder) other;
			
			merger.mergeRosetta(getBespokeCalculationDate(), o.getBespokeCalculationDate(), this::setBespokeCalculationDate);
			merger.mergeRosetta(getBespokeCalculationTime(), o.getBespokeCalculationTime(), this::setBespokeCalculationTime);
			merger.mergeRosetta(getCalculationAgentTerms(), o.getCalculationAgentTerms(), this::setCalculationAgentTerms);
			merger.mergeRosetta(getCalculationDateLocation(), o.getCalculationDateLocation(), this::setCalculationDateLocation);
			merger.mergeRosetta(getCollateralValuationAgent(), o.getCollateralValuationAgent(), this::setCollateralValuationAgent);
			merger.mergeRosetta(getNotificationTime(), o.getNotificationTime(), this::setNotificationTime);
			
			merger.mergeBasic(getCashSettlementDay(), o.getCashSettlementDay(), this::setCashSettlementDay);
			merger.mergeBasic(getSecuritiesSettlementDay(), o.getSecuritiesSettlementDay(), this::setSecuritiesSettlementDay);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAndTiming _that = getType().cast(o);
		
			if (!Objects.equals(bespokeCalculationDate, _that.getBespokeCalculationDate())) return false;
			if (!Objects.equals(bespokeCalculationTime, _that.getBespokeCalculationTime())) return false;
			if (!Objects.equals(calculationAgentTerms, _that.getCalculationAgentTerms())) return false;
			if (!Objects.equals(calculationDateLocation, _that.getCalculationDateLocation())) return false;
			if (!Objects.equals(cashSettlementDay, _that.getCashSettlementDay())) return false;
			if (!Objects.equals(collateralValuationAgent, _that.getCollateralValuationAgent())) return false;
			if (!Objects.equals(notificationTime, _that.getNotificationTime())) return false;
			if (!Objects.equals(securitiesSettlementDay, _that.getSecuritiesSettlementDay())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeCalculationDate != null ? bespokeCalculationDate.hashCode() : 0);
			_result = 31 * _result + (bespokeCalculationTime != null ? bespokeCalculationTime.hashCode() : 0);
			_result = 31 * _result + (calculationAgentTerms != null ? calculationAgentTerms.hashCode() : 0);
			_result = 31 * _result + (calculationDateLocation != null ? calculationDateLocation.hashCode() : 0);
			_result = 31 * _result + (cashSettlementDay != null ? cashSettlementDay.hashCode() : 0);
			_result = 31 * _result + (collateralValuationAgent != null ? collateralValuationAgent.hashCode() : 0);
			_result = 31 * _result + (notificationTime != null ? notificationTime.hashCode() : 0);
			_result = 31 * _result + (securitiesSettlementDay != null ? securitiesSettlementDay.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAndTimingBuilder {" +
				"bespokeCalculationDate=" + this.bespokeCalculationDate + ", " +
				"bespokeCalculationTime=" + this.bespokeCalculationTime + ", " +
				"calculationAgentTerms=" + this.calculationAgentTerms + ", " +
				"calculationDateLocation=" + this.calculationDateLocation + ", " +
				"cashSettlementDay=" + this.cashSettlementDay + ", " +
				"collateralValuationAgent=" + this.collateralValuationAgent + ", " +
				"notificationTime=" + this.notificationTime + ", " +
				"securitiesSettlementDay=" + this.securitiesSettlementDay +
			'}';
		}
	}
}
