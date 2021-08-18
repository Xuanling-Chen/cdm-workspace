package cdm.event.workflow;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
import cdm.event.workflow.meta.PartyCustomisedWorkflowMeta;
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
 * A class to specify a party-related, non-standardized data in a generic form.
 * @version ${project.version}
 */
@RosettaClass

public interface PartyCustomisedWorkflow extends RosettaModelObject {
	PartyCustomisedWorkflow build();
	PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder toBuilder();
	
	/**
	 * Non-standardized data in a generic form.
	 */
	List<? extends CustomisedWorkflow> getCustomisedWorkflow();
	/**
	 * The party name to which the workflow pertains to.
	 */
	String getPartyName();
	/**
	 * Reference to the party to which the workflow pertains to.
	 */
	ReferenceWithMetaParty getPartyReference();
	final static PartyCustomisedWorkflowMeta metaData = new PartyCustomisedWorkflowMeta();
	
	@Override
	default RosettaMetaData<? extends PartyCustomisedWorkflow> metaData() {
		return metaData;
	} 
			
	static PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder builder() {
		return new PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilderImpl();
	}
	
	default Class<? extends PartyCustomisedWorkflow> getType() {
		return PartyCustomisedWorkflow.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("partyName"), String.class, getPartyName(), this);
		
		processRosetta(path.newSubPath("customisedWorkflow"), processor, CustomisedWorkflow.class, getCustomisedWorkflow());
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
	}
	
	
	interface PartyCustomisedWorkflowBuilder extends PartyCustomisedWorkflow, RosettaModelObjectBuilder {
		CustomisedWorkflow.CustomisedWorkflowBuilder getOrCreateCustomisedWorkflow(int _index);
		List<? extends CustomisedWorkflow.CustomisedWorkflowBuilder> getCustomisedWorkflow();
		ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		ReferenceWithMetaPartyBuilder getPartyReference();
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(CustomisedWorkflow customisedWorkflow);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(CustomisedWorkflow customisedWorkflow, int _idx);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(List<? extends CustomisedWorkflow> customisedWorkflow);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setCustomisedWorkflow(List<? extends CustomisedWorkflow> customisedWorkflow);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyName(String partyName);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyReferenceValue(Party partyReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("partyName"), String.class, getPartyName(), this);
			
			processRosetta(path.newSubPath("customisedWorkflow"), processor, CustomisedWorkflow.CustomisedWorkflowBuilder.class, getCustomisedWorkflow());
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPartyReference());
		}
		
	}
	
	//PartyCustomisedWorkflow.PartyCustomisedWorkflowImpl
	class PartyCustomisedWorkflowImpl implements PartyCustomisedWorkflow {
		private final List<? extends CustomisedWorkflow> customisedWorkflow;
		private final String partyName;
		private final ReferenceWithMetaParty partyReference;
		
		protected PartyCustomisedWorkflowImpl(PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder builder) {
			this.customisedWorkflow = ofNullable(builder.getCustomisedWorkflow()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyName = builder.getPartyName();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends CustomisedWorkflow> getCustomisedWorkflow() {
			return customisedWorkflow;
		}
		
		@Override
		public String getPartyName() {
			return partyName;
		}
		
		@Override
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyCustomisedWorkflow build() {
			return this;
		}
		
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder toBuilder() {
			PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder builder) {
			ofNullable(getCustomisedWorkflow()).ifPresent(builder::setCustomisedWorkflow);
			ofNullable(getPartyName()).ifPresent(builder::setPartyName);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyCustomisedWorkflow _that = getType().cast(o);
		
			if (!ListEquals.listEquals(customisedWorkflow, _that.getCustomisedWorkflow())) return false;
			if (!Objects.equals(partyName, _that.getPartyName())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customisedWorkflow != null ? customisedWorkflow.hashCode() : 0);
			_result = 31 * _result + (partyName != null ? partyName.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyCustomisedWorkflow {" +
				"customisedWorkflow=" + this.customisedWorkflow + ", " +
				"partyName=" + this.partyName + ", " +
				"partyReference=" + this.partyReference +
			'}';
		}
	}
	
	//PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilderImpl
	class PartyCustomisedWorkflowBuilderImpl implements PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder {
	
		protected List<CustomisedWorkflow.CustomisedWorkflowBuilder> customisedWorkflow = new ArrayList<>();
		protected String partyName;
		protected ReferenceWithMetaPartyBuilder partyReference;
	
		public PartyCustomisedWorkflowBuilderImpl() {
		}
	
		@Override
		public List<? extends CustomisedWorkflow.CustomisedWorkflowBuilder> getCustomisedWorkflow() {
			return customisedWorkflow;
		}
		
		public CustomisedWorkflow.CustomisedWorkflowBuilder getOrCreateCustomisedWorkflow(int _index) {
		
			if (customisedWorkflow==null) {
				this.customisedWorkflow = new ArrayList<>();
			}
			CustomisedWorkflow.CustomisedWorkflowBuilder result;
			return getIndex(customisedWorkflow, _index, () -> {
						CustomisedWorkflow.CustomisedWorkflowBuilder newCustomisedWorkflow = CustomisedWorkflow.builder();
						return newCustomisedWorkflow;
					});
		}
		
		@Override
		public String getPartyName() {
			return partyName;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreatePartyReference() {
			ReferenceWithMetaPartyBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(CustomisedWorkflow customisedWorkflow) {
			if (customisedWorkflow!=null) this.customisedWorkflow.add(customisedWorkflow.toBuilder());
			return this;
		}
		
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(CustomisedWorkflow customisedWorkflow, int _idx) {
			getIndex(this.customisedWorkflow, _idx, () -> customisedWorkflow.toBuilder());
			return this;
		}
		@Override 
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder addCustomisedWorkflow(List<? extends CustomisedWorkflow> customisedWorkflows) {
			if (customisedWorkflows != null) {
				for (CustomisedWorkflow toAdd : customisedWorkflows) {
					this.customisedWorkflow.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setCustomisedWorkflow(List<? extends CustomisedWorkflow> customisedWorkflows) {
			if (customisedWorkflows == null)  {
				this.customisedWorkflow = new ArrayList<>();
			}
			else {
				this.customisedWorkflow = customisedWorkflows.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyName(String partyName) {
			this.partyName = partyName==null?null:partyName;
			return this;
		}
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyReference(ReferenceWithMetaParty partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder setPartyReferenceValue(Party partyReference) {
			this.getOrCreatePartyReference().setValue(partyReference);
			return this;
		}
		
		@Override
		public PartyCustomisedWorkflow build() {
			return new PartyCustomisedWorkflow.PartyCustomisedWorkflowImpl(this);
		}
		
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder prune() {
			customisedWorkflow = customisedWorkflow.stream().filter(b->b!=null).<CustomisedWorkflow.CustomisedWorkflowBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustomisedWorkflow()!=null && getCustomisedWorkflow().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyName()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder o = (PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder) other;
			
			merger.mergeRosetta(getCustomisedWorkflow(), o.getCustomisedWorkflow(), this::getOrCreateCustomisedWorkflow);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			
			merger.mergeBasic(getPartyName(), o.getPartyName(), this::setPartyName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyCustomisedWorkflow _that = getType().cast(o);
		
			if (!ListEquals.listEquals(customisedWorkflow, _that.getCustomisedWorkflow())) return false;
			if (!Objects.equals(partyName, _that.getPartyName())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customisedWorkflow != null ? customisedWorkflow.hashCode() : 0);
			_result = 31 * _result + (partyName != null ? partyName.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyCustomisedWorkflowBuilder {" +
				"customisedWorkflow=" + this.customisedWorkflow + ", " +
				"partyName=" + this.partyName + ", " +
				"partyReference=" + this.partyReference +
			'}';
		}
	}
}
