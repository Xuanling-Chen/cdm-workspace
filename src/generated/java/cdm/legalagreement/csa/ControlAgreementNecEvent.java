package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.ControlAgreementNecEventMeta;
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
 * A class to specify Control Agreement language related to delivery of a Notice of Exclusive Control
 * @version ${project.version}
 */
@RosettaClass

public interface ControlAgreementNecEvent extends RosettaModelObject {
	ControlAgreementNecEvent build();
	ControlAgreementNecEvent.ControlAgreementNecEventBuilder toBuilder();
	
	/**
	 */
	List<? extends ControlAgreementNecEventElection> getControlAgreementNecEventElection();
	final static ControlAgreementNecEventMeta metaData = new ControlAgreementNecEventMeta();
	
	@Override
	default RosettaMetaData<? extends ControlAgreementNecEvent> metaData() {
		return metaData;
	} 
			
	static ControlAgreementNecEvent.ControlAgreementNecEventBuilder builder() {
		return new ControlAgreementNecEvent.ControlAgreementNecEventBuilderImpl();
	}
	
	default Class<? extends ControlAgreementNecEvent> getType() {
		return ControlAgreementNecEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("controlAgreementNecEventElection"), processor, ControlAgreementNecEventElection.class, getControlAgreementNecEventElection());
	}
	
	
	interface ControlAgreementNecEventBuilder extends ControlAgreementNecEvent, RosettaModelObjectBuilder {
		ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder getOrCreateControlAgreementNecEventElection(int _index);
		List<? extends ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder> getControlAgreementNecEventElection();
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(ControlAgreementNecEventElection controlAgreementNecEventElection);
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(ControlAgreementNecEventElection controlAgreementNecEventElection, int _idx);
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(List<? extends ControlAgreementNecEventElection> controlAgreementNecEventElection);
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder setControlAgreementNecEventElection(List<? extends ControlAgreementNecEventElection> controlAgreementNecEventElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("controlAgreementNecEventElection"), processor, ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder.class, getControlAgreementNecEventElection());
		}
		
	}
	
	//ControlAgreementNecEvent.ControlAgreementNecEventImpl
	class ControlAgreementNecEventImpl implements ControlAgreementNecEvent {
		private final List<? extends ControlAgreementNecEventElection> controlAgreementNecEventElection;
		
		protected ControlAgreementNecEventImpl(ControlAgreementNecEvent.ControlAgreementNecEventBuilder builder) {
			this.controlAgreementNecEventElection = ofNullable(builder.getControlAgreementNecEventElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ControlAgreementNecEventElection> getControlAgreementNecEventElection() {
			return controlAgreementNecEventElection;
		}
		
		@Override
		public ControlAgreementNecEvent build() {
			return this;
		}
		
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder toBuilder() {
			ControlAgreementNecEvent.ControlAgreementNecEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ControlAgreementNecEvent.ControlAgreementNecEventBuilder builder) {
			ofNullable(getControlAgreementNecEventElection()).ifPresent(builder::setControlAgreementNecEventElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementNecEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(controlAgreementNecEventElection, _that.getControlAgreementNecEventElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (controlAgreementNecEventElection != null ? controlAgreementNecEventElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementNecEvent {" +
				"controlAgreementNecEventElection=" + this.controlAgreementNecEventElection +
			'}';
		}
	}
	
	//ControlAgreementNecEvent.ControlAgreementNecEventBuilderImpl
	class ControlAgreementNecEventBuilderImpl implements ControlAgreementNecEvent.ControlAgreementNecEventBuilder {
	
		protected List<ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder> controlAgreementNecEventElection = new ArrayList<>();
	
		public ControlAgreementNecEventBuilderImpl() {
		}
	
		@Override
		public List<? extends ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder> getControlAgreementNecEventElection() {
			return controlAgreementNecEventElection;
		}
		
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder getOrCreateControlAgreementNecEventElection(int _index) {
		
			if (controlAgreementNecEventElection==null) {
				this.controlAgreementNecEventElection = new ArrayList<>();
			}
			ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder result;
			return getIndex(controlAgreementNecEventElection, _index, () -> {
						ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder newControlAgreementNecEventElection = ControlAgreementNecEventElection.builder();
						return newControlAgreementNecEventElection;
					});
		}
		
	
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(ControlAgreementNecEventElection controlAgreementNecEventElection) {
			if (controlAgreementNecEventElection!=null) this.controlAgreementNecEventElection.add(controlAgreementNecEventElection.toBuilder());
			return this;
		}
		
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(ControlAgreementNecEventElection controlAgreementNecEventElection, int _idx) {
			getIndex(this.controlAgreementNecEventElection, _idx, () -> controlAgreementNecEventElection.toBuilder());
			return this;
		}
		@Override 
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(List<? extends ControlAgreementNecEventElection> controlAgreementNecEventElections) {
			if (controlAgreementNecEventElections != null) {
				for (ControlAgreementNecEventElection toAdd : controlAgreementNecEventElections) {
					this.controlAgreementNecEventElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder setControlAgreementNecEventElection(List<? extends ControlAgreementNecEventElection> controlAgreementNecEventElections) {
			if (controlAgreementNecEventElections == null)  {
				this.controlAgreementNecEventElection = new ArrayList<>();
			}
			else {
				this.controlAgreementNecEventElection = controlAgreementNecEventElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ControlAgreementNecEvent build() {
			return new ControlAgreementNecEvent.ControlAgreementNecEventImpl(this);
		}
		
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder prune() {
			controlAgreementNecEventElection = controlAgreementNecEventElection.stream().filter(b->b!=null).<ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getControlAgreementNecEventElection()!=null && getControlAgreementNecEventElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ControlAgreementNecEvent.ControlAgreementNecEventBuilder o = (ControlAgreementNecEvent.ControlAgreementNecEventBuilder) other;
			
			merger.mergeRosetta(getControlAgreementNecEventElection(), o.getControlAgreementNecEventElection(), this::getOrCreateControlAgreementNecEventElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementNecEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(controlAgreementNecEventElection, _that.getControlAgreementNecEventElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (controlAgreementNecEventElection != null ? controlAgreementNecEventElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementNecEventBuilder {" +
				"controlAgreementNecEventElection=" + this.controlAgreementNecEventElection +
			'}';
		}
	}
}
