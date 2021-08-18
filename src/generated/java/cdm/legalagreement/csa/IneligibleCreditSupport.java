package cdm.legalagreement.csa;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
import cdm.legalagreement.csa.meta.IneligibleCreditSupportMeta;
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
 * A class to specify the parties to which the provisions of Paragraph 11(g) of the ISDA 2016 Credit Support Annex for Variation Margin will apply to. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(iii): Legally Ineligible Credit Support (VM).
 * @version ${project.version}
 */
@RosettaClass

public interface IneligibleCreditSupport extends RosettaModelObject {
	IneligibleCreditSupport build();
	IneligibleCreditSupport.IneligibleCreditSupportBuilder toBuilder();
	
	/**
	 * The parties to which the provisions of Paragraph 11(g) of the ISDA 2016 Credit Support Annex for Variation Margin will apply to, as the Secured Party. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (c)(iii): Legally Ineligible Credit Support (VM).
	 */
	List<? extends ReferenceWithMetaParty> getSpecifiedParty();
	/**
	 * Total Ineligibility Date has the meaning specified in Paragraph 11(g), unless otherwise specified here.
	 */
	String getTotalIneligibilityDate();
	/**
	 * Transfer Ineligibility Date has the meaning specified in Paragraph 11(g), unless otherwise specified here.
	 */
	String getTransferIneligibilityDate();
	final static IneligibleCreditSupportMeta metaData = new IneligibleCreditSupportMeta();
	
	@Override
	default RosettaMetaData<? extends IneligibleCreditSupport> metaData() {
		return metaData;
	} 
			
	static IneligibleCreditSupport.IneligibleCreditSupportBuilder builder() {
		return new IneligibleCreditSupport.IneligibleCreditSupportBuilderImpl();
	}
	
	default Class<? extends IneligibleCreditSupport> getType() {
		return IneligibleCreditSupport.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("totalIneligibilityDate"), String.class, getTotalIneligibilityDate(), this);
		processor.processBasic(path.newSubPath("transferIneligibilityDate"), String.class, getTransferIneligibilityDate(), this);
		
		processRosetta(path.newSubPath("specifiedParty"), processor, ReferenceWithMetaParty.class, getSpecifiedParty());
	}
	
	
	interface IneligibleCreditSupportBuilder extends IneligibleCreditSupport, RosettaModelObjectBuilder {
		ReferenceWithMetaPartyBuilder getOrCreateSpecifiedParty(int _index);
		List<? extends ReferenceWithMetaPartyBuilder> getSpecifiedParty();
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(ReferenceWithMetaParty specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(ReferenceWithMetaParty specifiedParty, int _idx);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(Party specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(Party specifiedParty, int _idx);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(List<? extends ReferenceWithMetaParty> specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder setSpecifiedParty(List<? extends ReferenceWithMetaParty> specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(List<? extends Party> specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder setSpecifiedPartyValue(List<? extends Party> specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder setTotalIneligibilityDate(String totalIneligibilityDate);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder setTransferIneligibilityDate(String transferIneligibilityDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("totalIneligibilityDate"), String.class, getTotalIneligibilityDate(), this);
			processor.processBasic(path.newSubPath("transferIneligibilityDate"), String.class, getTransferIneligibilityDate(), this);
			
			processRosetta(path.newSubPath("specifiedParty"), processor, ReferenceWithMetaPartyBuilder.class, getSpecifiedParty());
		}
		
	}
	
	//IneligibleCreditSupport.IneligibleCreditSupportImpl
	class IneligibleCreditSupportImpl implements IneligibleCreditSupport {
		private final List<? extends ReferenceWithMetaParty> specifiedParty;
		private final String totalIneligibilityDate;
		private final String transferIneligibilityDate;
		
		protected IneligibleCreditSupportImpl(IneligibleCreditSupport.IneligibleCreditSupportBuilder builder) {
			this.specifiedParty = ofNullable(builder.getSpecifiedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.totalIneligibilityDate = builder.getTotalIneligibilityDate();
			this.transferIneligibilityDate = builder.getTransferIneligibilityDate();
		}
		
		@Override
		public List<? extends ReferenceWithMetaParty> getSpecifiedParty() {
			return specifiedParty;
		}
		
		@Override
		public String getTotalIneligibilityDate() {
			return totalIneligibilityDate;
		}
		
		@Override
		public String getTransferIneligibilityDate() {
			return transferIneligibilityDate;
		}
		
		@Override
		public IneligibleCreditSupport build() {
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder toBuilder() {
			IneligibleCreditSupport.IneligibleCreditSupportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IneligibleCreditSupport.IneligibleCreditSupportBuilder builder) {
			ofNullable(getSpecifiedParty()).ifPresent(builder::setSpecifiedParty);
			ofNullable(getTotalIneligibilityDate()).ifPresent(builder::setTotalIneligibilityDate);
			ofNullable(getTransferIneligibilityDate()).ifPresent(builder::setTransferIneligibilityDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IneligibleCreditSupport _that = getType().cast(o);
		
			if (!ListEquals.listEquals(specifiedParty, _that.getSpecifiedParty())) return false;
			if (!Objects.equals(totalIneligibilityDate, _that.getTotalIneligibilityDate())) return false;
			if (!Objects.equals(transferIneligibilityDate, _that.getTransferIneligibilityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specifiedParty != null ? specifiedParty.hashCode() : 0);
			_result = 31 * _result + (totalIneligibilityDate != null ? totalIneligibilityDate.hashCode() : 0);
			_result = 31 * _result + (transferIneligibilityDate != null ? transferIneligibilityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IneligibleCreditSupport {" +
				"specifiedParty=" + this.specifiedParty + ", " +
				"totalIneligibilityDate=" + this.totalIneligibilityDate + ", " +
				"transferIneligibilityDate=" + this.transferIneligibilityDate +
			'}';
		}
	}
	
	//IneligibleCreditSupport.IneligibleCreditSupportBuilderImpl
	class IneligibleCreditSupportBuilderImpl implements IneligibleCreditSupport.IneligibleCreditSupportBuilder {
	
		protected List<ReferenceWithMetaPartyBuilder> specifiedParty = new ArrayList<>();
		protected String totalIneligibilityDate;
		protected String transferIneligibilityDate;
	
		public IneligibleCreditSupportBuilderImpl() {
		}
	
		@Override
		public List<? extends ReferenceWithMetaPartyBuilder> getSpecifiedParty() {
			return specifiedParty;
		}
		
		public ReferenceWithMetaPartyBuilder getOrCreateSpecifiedParty(int _index) {
		
			if (specifiedParty==null) {
				this.specifiedParty = new ArrayList<>();
			}
			ReferenceWithMetaPartyBuilder result;
			return getIndex(specifiedParty, _index, () -> {
						ReferenceWithMetaPartyBuilder newSpecifiedParty = ReferenceWithMetaParty.builder();
						return newSpecifiedParty;
					});
		}
		
		@Override
		public String getTotalIneligibilityDate() {
			return totalIneligibilityDate;
		}
		
		@Override
		public String getTransferIneligibilityDate() {
			return transferIneligibilityDate;
		}
		
	
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(ReferenceWithMetaParty specifiedParty) {
			if (specifiedParty!=null) this.specifiedParty.add(specifiedParty.toBuilder());
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(ReferenceWithMetaParty specifiedParty, int _idx) {
			getIndex(this.specifiedParty, _idx, () -> specifiedParty.toBuilder());
			return this;
		}
		
			@Override
			public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(Party specifiedParty) {
				this.getOrCreateSpecifiedParty(-1).setValue(specifiedParty.toBuilder());
				return this;
			}
			
			@Override
			public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(Party specifiedParty, int _idx) {
				this.getOrCreateSpecifiedParty(_idx).setValue(specifiedParty.toBuilder());
				return this;
			}
		@Override 
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(List<? extends ReferenceWithMetaParty> specifiedPartys) {
			if (specifiedPartys != null) {
				for (ReferenceWithMetaParty toAdd : specifiedPartys) {
					this.specifiedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder setSpecifiedParty(List<? extends ReferenceWithMetaParty> specifiedPartys) {
			if (specifiedPartys == null)  {
				this.specifiedParty = new ArrayList<>();
			}
			else {
				this.specifiedParty = specifiedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(List<? extends Party> specifiedPartys) {
			if (specifiedPartys != null) {
				for (Party toAdd : specifiedPartys) {
					this.addSpecifiedPartyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder setSpecifiedPartyValue(List<? extends Party> specifiedPartys) {
			this.specifiedParty.clear();
			if (specifiedPartys!=null) {
				specifiedPartys.forEach(this::addSpecifiedPartyValue);
			}
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder setTotalIneligibilityDate(String totalIneligibilityDate) {
			this.totalIneligibilityDate = totalIneligibilityDate==null?null:totalIneligibilityDate;
			return this;
		}
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder setTransferIneligibilityDate(String transferIneligibilityDate) {
			this.transferIneligibilityDate = transferIneligibilityDate==null?null:transferIneligibilityDate;
			return this;
		}
		
		@Override
		public IneligibleCreditSupport build() {
			return new IneligibleCreditSupport.IneligibleCreditSupportImpl(this);
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder prune() {
			specifiedParty = specifiedParty.stream().filter(b->b!=null).<ReferenceWithMetaPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpecifiedParty()!=null && getSpecifiedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTotalIneligibilityDate()!=null) return true;
			if (getTransferIneligibilityDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IneligibleCreditSupport.IneligibleCreditSupportBuilder o = (IneligibleCreditSupport.IneligibleCreditSupportBuilder) other;
			
			merger.mergeRosetta(getSpecifiedParty(), o.getSpecifiedParty(), this::getOrCreateSpecifiedParty);
			
			merger.mergeBasic(getTotalIneligibilityDate(), o.getTotalIneligibilityDate(), this::setTotalIneligibilityDate);
			merger.mergeBasic(getTransferIneligibilityDate(), o.getTransferIneligibilityDate(), this::setTransferIneligibilityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IneligibleCreditSupport _that = getType().cast(o);
		
			if (!ListEquals.listEquals(specifiedParty, _that.getSpecifiedParty())) return false;
			if (!Objects.equals(totalIneligibilityDate, _that.getTotalIneligibilityDate())) return false;
			if (!Objects.equals(transferIneligibilityDate, _that.getTransferIneligibilityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specifiedParty != null ? specifiedParty.hashCode() : 0);
			_result = 31 * _result + (totalIneligibilityDate != null ? totalIneligibilityDate.hashCode() : 0);
			_result = 31 * _result + (transferIneligibilityDate != null ? transferIneligibilityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IneligibleCreditSupportBuilder {" +
				"specifiedParty=" + this.specifiedParty + ", " +
				"totalIneligibilityDate=" + this.totalIneligibilityDate + ", " +
				"transferIneligibilityDate=" + this.transferIneligibilityDate +
			'}';
		}
	}
}
