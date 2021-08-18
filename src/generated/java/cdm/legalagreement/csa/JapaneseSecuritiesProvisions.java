package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.JapaneseSecuritiesProvisionsMeta;
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
 * A class to specify Japanese Securities Provision elections.
 * @version ${project.version}
 */
@RosettaClass

public interface JapaneseSecuritiesProvisions extends RosettaModelObject {
	JapaneseSecuritiesProvisions build();
	JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder toBuilder();
	
	/**
	 * Additional Amendments to Japanese Securities Provisions are specified when True, and not specified when False
	 */
	Boolean getAmendmentsToJapaneseProvisions();
	/**
	 * Specific terms applicable to Additional Amendments to Japanese Securities Provisions
	 */
	String getAmendmentsToJapaneseProvisionsTerms();
	/**
	 * Specification of whether Clearstream Event amendment language is included (true) or excluded (false).
	 */
	Boolean getClearstreamAmendmentToJapaneseProvisions();
	/**
	 * Japanese Securities Provisions are applicable when True and Not Applicable when False
	 */
	Boolean getIsApplicable();
	/**
	 * Recommended Japanese Securities Provisions are applicable when True, additional Provisions are specified when False
	 */
	Boolean getRelevantProvisionsElection();
	/**
	 * Specific terms applicable to Recommended Japanese Securities Provisions
	 */
	String getRelevantProvisionsTerms();
	final static JapaneseSecuritiesProvisionsMeta metaData = new JapaneseSecuritiesProvisionsMeta();
	
	@Override
	default RosettaMetaData<? extends JapaneseSecuritiesProvisions> metaData() {
		return metaData;
	} 
			
	static JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder builder() {
		return new JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilderImpl();
	}
	
	default Class<? extends JapaneseSecuritiesProvisions> getType() {
		return JapaneseSecuritiesProvisions.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("amendmentsToJapaneseProvisions"), Boolean.class, getAmendmentsToJapaneseProvisions(), this);
		processor.processBasic(path.newSubPath("amendmentsToJapaneseProvisionsTerms"), String.class, getAmendmentsToJapaneseProvisionsTerms(), this);
		processor.processBasic(path.newSubPath("clearstreamAmendmentToJapaneseProvisions"), Boolean.class, getClearstreamAmendmentToJapaneseProvisions(), this);
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("relevantProvisionsElection"), Boolean.class, getRelevantProvisionsElection(), this);
		processor.processBasic(path.newSubPath("relevantProvisionsTerms"), String.class, getRelevantProvisionsTerms(), this);
		
	}
	
	
	interface JapaneseSecuritiesProvisionsBuilder extends JapaneseSecuritiesProvisions, RosettaModelObjectBuilder {
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setAmendmentsToJapaneseProvisions(Boolean amendmentsToJapaneseProvisions);
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setAmendmentsToJapaneseProvisionsTerms(String amendmentsToJapaneseProvisionsTerms);
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setClearstreamAmendmentToJapaneseProvisions(Boolean clearstreamAmendmentToJapaneseProvisions);
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setIsApplicable(Boolean isApplicable);
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setRelevantProvisionsElection(Boolean relevantProvisionsElection);
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setRelevantProvisionsTerms(String relevantProvisionsTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("amendmentsToJapaneseProvisions"), Boolean.class, getAmendmentsToJapaneseProvisions(), this);
			processor.processBasic(path.newSubPath("amendmentsToJapaneseProvisionsTerms"), String.class, getAmendmentsToJapaneseProvisionsTerms(), this);
			processor.processBasic(path.newSubPath("clearstreamAmendmentToJapaneseProvisions"), Boolean.class, getClearstreamAmendmentToJapaneseProvisions(), this);
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("relevantProvisionsElection"), Boolean.class, getRelevantProvisionsElection(), this);
			processor.processBasic(path.newSubPath("relevantProvisionsTerms"), String.class, getRelevantProvisionsTerms(), this);
			
		}
		
	}
	
	//JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsImpl
	class JapaneseSecuritiesProvisionsImpl implements JapaneseSecuritiesProvisions {
		private final Boolean amendmentsToJapaneseProvisions;
		private final String amendmentsToJapaneseProvisionsTerms;
		private final Boolean clearstreamAmendmentToJapaneseProvisions;
		private final Boolean isApplicable;
		private final Boolean relevantProvisionsElection;
		private final String relevantProvisionsTerms;
		
		protected JapaneseSecuritiesProvisionsImpl(JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder builder) {
			this.amendmentsToJapaneseProvisions = builder.getAmendmentsToJapaneseProvisions();
			this.amendmentsToJapaneseProvisionsTerms = builder.getAmendmentsToJapaneseProvisionsTerms();
			this.clearstreamAmendmentToJapaneseProvisions = builder.getClearstreamAmendmentToJapaneseProvisions();
			this.isApplicable = builder.getIsApplicable();
			this.relevantProvisionsElection = builder.getRelevantProvisionsElection();
			this.relevantProvisionsTerms = builder.getRelevantProvisionsTerms();
		}
		
		@Override
		public Boolean getAmendmentsToJapaneseProvisions() {
			return amendmentsToJapaneseProvisions;
		}
		
		@Override
		public String getAmendmentsToJapaneseProvisionsTerms() {
			return amendmentsToJapaneseProvisionsTerms;
		}
		
		@Override
		public Boolean getClearstreamAmendmentToJapaneseProvisions() {
			return clearstreamAmendmentToJapaneseProvisions;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public Boolean getRelevantProvisionsElection() {
			return relevantProvisionsElection;
		}
		
		@Override
		public String getRelevantProvisionsTerms() {
			return relevantProvisionsTerms;
		}
		
		@Override
		public JapaneseSecuritiesProvisions build() {
			return this;
		}
		
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder toBuilder() {
			JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder builder) {
			ofNullable(getAmendmentsToJapaneseProvisions()).ifPresent(builder::setAmendmentsToJapaneseProvisions);
			ofNullable(getAmendmentsToJapaneseProvisionsTerms()).ifPresent(builder::setAmendmentsToJapaneseProvisionsTerms);
			ofNullable(getClearstreamAmendmentToJapaneseProvisions()).ifPresent(builder::setClearstreamAmendmentToJapaneseProvisions);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getRelevantProvisionsElection()).ifPresent(builder::setRelevantProvisionsElection);
			ofNullable(getRelevantProvisionsTerms()).ifPresent(builder::setRelevantProvisionsTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			JapaneseSecuritiesProvisions _that = getType().cast(o);
		
			if (!Objects.equals(amendmentsToJapaneseProvisions, _that.getAmendmentsToJapaneseProvisions())) return false;
			if (!Objects.equals(amendmentsToJapaneseProvisionsTerms, _that.getAmendmentsToJapaneseProvisionsTerms())) return false;
			if (!Objects.equals(clearstreamAmendmentToJapaneseProvisions, _that.getClearstreamAmendmentToJapaneseProvisions())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(relevantProvisionsElection, _that.getRelevantProvisionsElection())) return false;
			if (!Objects.equals(relevantProvisionsTerms, _that.getRelevantProvisionsTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amendmentsToJapaneseProvisions != null ? amendmentsToJapaneseProvisions.hashCode() : 0);
			_result = 31 * _result + (amendmentsToJapaneseProvisionsTerms != null ? amendmentsToJapaneseProvisionsTerms.hashCode() : 0);
			_result = 31 * _result + (clearstreamAmendmentToJapaneseProvisions != null ? clearstreamAmendmentToJapaneseProvisions.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (relevantProvisionsElection != null ? relevantProvisionsElection.hashCode() : 0);
			_result = 31 * _result + (relevantProvisionsTerms != null ? relevantProvisionsTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JapaneseSecuritiesProvisions {" +
				"amendmentsToJapaneseProvisions=" + this.amendmentsToJapaneseProvisions + ", " +
				"amendmentsToJapaneseProvisionsTerms=" + this.amendmentsToJapaneseProvisionsTerms + ", " +
				"clearstreamAmendmentToJapaneseProvisions=" + this.clearstreamAmendmentToJapaneseProvisions + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"relevantProvisionsElection=" + this.relevantProvisionsElection + ", " +
				"relevantProvisionsTerms=" + this.relevantProvisionsTerms +
			'}';
		}
	}
	
	//JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilderImpl
	class JapaneseSecuritiesProvisionsBuilderImpl implements JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder {
	
		protected Boolean amendmentsToJapaneseProvisions;
		protected String amendmentsToJapaneseProvisionsTerms;
		protected Boolean clearstreamAmendmentToJapaneseProvisions;
		protected Boolean isApplicable;
		protected Boolean relevantProvisionsElection;
		protected String relevantProvisionsTerms;
	
		public JapaneseSecuritiesProvisionsBuilderImpl() {
		}
	
		@Override
		public Boolean getAmendmentsToJapaneseProvisions() {
			return amendmentsToJapaneseProvisions;
		}
		
		@Override
		public String getAmendmentsToJapaneseProvisionsTerms() {
			return amendmentsToJapaneseProvisionsTerms;
		}
		
		@Override
		public Boolean getClearstreamAmendmentToJapaneseProvisions() {
			return clearstreamAmendmentToJapaneseProvisions;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public Boolean getRelevantProvisionsElection() {
			return relevantProvisionsElection;
		}
		
		@Override
		public String getRelevantProvisionsTerms() {
			return relevantProvisionsTerms;
		}
		
	
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setAmendmentsToJapaneseProvisions(Boolean amendmentsToJapaneseProvisions) {
			this.amendmentsToJapaneseProvisions = amendmentsToJapaneseProvisions==null?null:amendmentsToJapaneseProvisions;
			return this;
		}
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setAmendmentsToJapaneseProvisionsTerms(String amendmentsToJapaneseProvisionsTerms) {
			this.amendmentsToJapaneseProvisionsTerms = amendmentsToJapaneseProvisionsTerms==null?null:amendmentsToJapaneseProvisionsTerms;
			return this;
		}
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setClearstreamAmendmentToJapaneseProvisions(Boolean clearstreamAmendmentToJapaneseProvisions) {
			this.clearstreamAmendmentToJapaneseProvisions = clearstreamAmendmentToJapaneseProvisions==null?null:clearstreamAmendmentToJapaneseProvisions;
			return this;
		}
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setRelevantProvisionsElection(Boolean relevantProvisionsElection) {
			this.relevantProvisionsElection = relevantProvisionsElection==null?null:relevantProvisionsElection;
			return this;
		}
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setRelevantProvisionsTerms(String relevantProvisionsTerms) {
			this.relevantProvisionsTerms = relevantProvisionsTerms==null?null:relevantProvisionsTerms;
			return this;
		}
		
		@Override
		public JapaneseSecuritiesProvisions build() {
			return new JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsImpl(this);
		}
		
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmendmentsToJapaneseProvisions()!=null) return true;
			if (getAmendmentsToJapaneseProvisionsTerms()!=null) return true;
			if (getClearstreamAmendmentToJapaneseProvisions()!=null) return true;
			if (getIsApplicable()!=null) return true;
			if (getRelevantProvisionsElection()!=null) return true;
			if (getRelevantProvisionsTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder o = (JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder) other;
			
			
			merger.mergeBasic(getAmendmentsToJapaneseProvisions(), o.getAmendmentsToJapaneseProvisions(), this::setAmendmentsToJapaneseProvisions);
			merger.mergeBasic(getAmendmentsToJapaneseProvisionsTerms(), o.getAmendmentsToJapaneseProvisionsTerms(), this::setAmendmentsToJapaneseProvisionsTerms);
			merger.mergeBasic(getClearstreamAmendmentToJapaneseProvisions(), o.getClearstreamAmendmentToJapaneseProvisions(), this::setClearstreamAmendmentToJapaneseProvisions);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getRelevantProvisionsElection(), o.getRelevantProvisionsElection(), this::setRelevantProvisionsElection);
			merger.mergeBasic(getRelevantProvisionsTerms(), o.getRelevantProvisionsTerms(), this::setRelevantProvisionsTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			JapaneseSecuritiesProvisions _that = getType().cast(o);
		
			if (!Objects.equals(amendmentsToJapaneseProvisions, _that.getAmendmentsToJapaneseProvisions())) return false;
			if (!Objects.equals(amendmentsToJapaneseProvisionsTerms, _that.getAmendmentsToJapaneseProvisionsTerms())) return false;
			if (!Objects.equals(clearstreamAmendmentToJapaneseProvisions, _that.getClearstreamAmendmentToJapaneseProvisions())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(relevantProvisionsElection, _that.getRelevantProvisionsElection())) return false;
			if (!Objects.equals(relevantProvisionsTerms, _that.getRelevantProvisionsTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amendmentsToJapaneseProvisions != null ? amendmentsToJapaneseProvisions.hashCode() : 0);
			_result = 31 * _result + (amendmentsToJapaneseProvisionsTerms != null ? amendmentsToJapaneseProvisionsTerms.hashCode() : 0);
			_result = 31 * _result + (clearstreamAmendmentToJapaneseProvisions != null ? clearstreamAmendmentToJapaneseProvisions.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (relevantProvisionsElection != null ? relevantProvisionsElection.hashCode() : 0);
			_result = 31 * _result + (relevantProvisionsTerms != null ? relevantProvisionsTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JapaneseSecuritiesProvisionsBuilder {" +
				"amendmentsToJapaneseProvisions=" + this.amendmentsToJapaneseProvisions + ", " +
				"amendmentsToJapaneseProvisionsTerms=" + this.amendmentsToJapaneseProvisionsTerms + ", " +
				"clearstreamAmendmentToJapaneseProvisions=" + this.clearstreamAmendmentToJapaneseProvisions + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"relevantProvisionsElection=" + this.relevantProvisionsElection + ", " +
				"relevantProvisionsTerms=" + this.relevantProvisionsTerms +
			'}';
		}
	}
}
